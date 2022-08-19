import React, {useState} from 'react';
import {makeStyles} from '@material-ui/core/styles';
import CssBaseline from '@material-ui/core/CssBaseline';
import Paper from '@material-ui/core/Paper';
import Stepper from '@material-ui/core/Stepper';
import Step from '@material-ui/core/Step';
import StepLabel from '@material-ui/core/StepLabel';
import Button from '@material-ui/core/Button';
import Typography from '@material-ui/core/Typography';
import TrainerDetails from './TrainerDetails';
import TrainerExp from './TrainerExp';
import axios from "axios";


const useStyles = makeStyles((theme) => ({
    appBar: {
        position: 'relative',
    },
    layout: {
        width: 'auto',
        marginLeft: theme.spacing(2),
        marginRight: theme.spacing(2),
        [theme.breakpoints.up(600 + theme.spacing(2) * 2)]: {
            width: 600,
            marginLeft: 'auto',
            marginRight: 'auto',
        },
    },
    paper: {
        marginTop: theme.spacing(3),
        marginBottom: theme.spacing(3),
        padding: theme.spacing(2),
        [theme.breakpoints.up(600 + theme.spacing(3) * 2)]: {
            marginTop: theme.spacing(6),
            marginBottom: theme.spacing(6),
            padding: theme.spacing(3),
        },
    },
    stepper: {
        padding: theme.spacing(3, 0, 5),
    },
    buttons: {
        display: 'flex',
        justifyContent: 'flex-end',
    },
    button: {
        marginTop: theme.spacing(3),
        marginLeft: theme.spacing(1),
    },
}));

const steps = ['Dane osobowe', 'Doświadczenie i wykształcenie'];


export default function TrainerProfile() {
    const defaultTrainerExp = [
        {
            dateFrame: "",
            workLocation: "",
            description: ""
        },
        {
            dateFrame: "",
            workLocation: "",
            description: ""
        },
        {
            dateFrame: "",
            workLocation: "",
            description: ""
        }];
    const defaultTrainerEdu = [
        {
            dateFrame: "",
            schoolName: ""
        },
        {
            dateFrame: "",
            schoolName: ""
        },
        {
            dateFrame: "",
            schoolName: ""
        }];
    const defaultTrainerCert = [
        {
            description: ""
        },
        {
            description: ""
        },
        {
            description: ""
        }];

    const classes = useStyles();

    const [activeStep, setActiveStep] = React.useState(0);

    const [name, setName] = useState("");
    const [lastName, setLastName] = useState("");
    const [address, setAddress] = useState("");
    const [city, setCity] = useState("");
    const [zipCode, setZipCode] = useState("");
    const [province, setProvince] = useState("");
    const [trainerExperiences, setTrainerExperiences] = useState(defaultTrainerExp);
    const [trainerEducations, setTrainerEducations] = useState(defaultTrainerEdu);
    const [trainerCertificates, setTrainerCertificates] = useState(defaultTrainerCert);


    const saveProfile = () => {
        const requestObject = {
            name: name,
            lastName: lastName,
            address: address,
            city: city,
            zipCode: zipCode,
            province: province,
            trainerExperiences: trainerExperiences,
            trainerEducations: trainerEducations,
            trainerCertificates: trainerCertificates,
        }
        console.log(requestObject);
        axios.post("/trainer/profile", requestObject)
            .then(data => {
                console.log(data);
            });

    }

    const getStepContent = (step) => {
        switch (step) {
            case 0:
                return <TrainerDetails name={name}
                                       setName={setName}
                                       lastName={lastName}
                                       setLastName={setLastName}
                                       address={address}
                                       setAddress={setAddress}
                                       city={city}
                                       setCity={setCity}
                                       zipCode={zipCode}
                                       setZipCode={setZipCode}
                                       province={province}
                                       setProvince={setProvince}/>;
            case 1:
                return <TrainerExp trainerExperiences={trainerExperiences}
                                   trainerEducations={trainerEducations}
                                   trainerCertificates={trainerCertificates}
                                   setTrainerExperiences={setTrainerExperiences}
                                   setTrainerEducations={setTrainerEducations}
                                   setTrainerCertificates={setTrainerCertificates}/>;
            default:
                throw new Error('Unknown step');
        }
    }

    const handleNext = () => {
        if (activeStep === steps.length - 1) {
            saveProfile();
        }
        setActiveStep(activeStep + 1);
    };

    const handleBack = () => {
        setActiveStep(activeStep - 1);
    };

    return (
        <React.Fragment>
            <CssBaseline/>
            <main className={classes.layout}>
                <Paper className={classes.paper}>
                    <Typography component="h1" variant="h4" align="center">
                        Profil trenera
                    </Typography>
                    <Stepper activeStep={activeStep} className={classes.stepper}>
                        {steps.map((label) => (
                            <Step key={label}>
                                <StepLabel>{label}</StepLabel>
                            </Step>
                        ))}
                    </Stepper>
                    <React.Fragment>
                        {activeStep === steps.length ? (
                            <React.Fragment>
                                <Typography variant="h5" gutterBottom>
                                    Dziękujemy za wprowadzenie swoich danych
                                </Typography>
                                <Typography variant="subtitle1">
                                    Automatyczne przekierowanie na stronę główna za ...3sec
                                </Typography>
                            </React.Fragment>
                        ) : (
                            <React.Fragment>
                                {getStepContent(activeStep)}
                                <div className={classes.buttons}>
                                    {activeStep !== 0 && (
                                        <Button onClick={handleBack} className={classes.button}>
                                            Powrót
                                        </Button>
                                    )}
                                    <Button
                                        variant="contained"
                                        color="primary"
                                        onClick={handleNext}
                                        className={classes.button}
                                    >
                                        {activeStep === steps.length - 1 ? 'Zakończ' : 'Następny krok'}
                                    </Button>
                                </div>
                            </React.Fragment>
                        )}
                    </React.Fragment>
                </Paper>
            </main>
        </React.Fragment>
    );
}