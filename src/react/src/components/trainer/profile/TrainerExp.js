import React from 'react';
import Typography from '@material-ui/core/Typography';
import Grid from '@material-ui/core/Grid';
import TextField from '@material-ui/core/TextField';
import Divider from "@material-ui/core/Divider";

export default function TrainerExp(props) {
    return (
        <React.Fragment>
            <Typography variant="h6" gutterBottom>
                Doświadczenie
            </Typography>
            <Grid container spacing={3}>
                <Grid item xs={12} md={6}>
                    <TextField required id="date1"
                               label="od - do"
                               fullWidth
                               value={props.trainerExperiences[0].dateFrame}
                               onChange={event => {
                                   const trainerExperiencesCopy = props.trainerExperiences.map(newValues => {
                                       return {...newValues};
                                   });
                                   trainerExperiencesCopy[0].dateFrame = event.target.value;
                                   props.setTrainerExperiences(trainerExperiencesCopy);
                               }}
                    />
                </Grid>
                <Grid item xs={12} md={6}>
                    <TextField
                        required
                        id="xxxxx"
                        label="miejsce pracy"
                        fullWidth
                        value={props.trainerExperiences[0].workLocation}
                        onChange={event => {
                            const trainerExperiencesCopy = props.trainerExperiences.map(newValues => {
                                return {...newValues};
                            });
                            trainerExperiencesCopy[0].workLocation = event.target.value;
                            props.setTrainerExperiences(trainerExperiencesCopy);
                        }}
                    />
                </Grid>
                <Grid item xs={12} md={12}>
                    <TextField
                        required
                        id="xxxxx"
                        label="opis"
                        fullWidth
                        multiline
                        rows={3}
                        value={props.trainerExperiences[0].description}
                        onChange={event => {
                            const trainerExperiencesCopy = props.trainerExperiences.map(newValues => {
                                return {...newValues};
                            });
                            trainerExperiencesCopy[0].description = event.target.value;
                            props.setTrainerExperiences(trainerExperiencesCopy);
                        }}
                    />
                </Grid>
                <Grid item xs={12} md={12}>
                    <Divider variant="middle"/>
                </Grid>

                <Grid item xs={12} md={6}>
                    <TextField required id="date1" label="od - do" fullWidth
                               value={props.trainerExperiences[1].dateFrame}
                               onChange={event => {
                                   const trainerExperiencesCopy = props.trainerExperiences.map(newValues => {
                                       return {...newValues};
                                   });
                                   trainerExperiencesCopy[1].dateFrame = event.target.value;
                                   props.setTrainerExperiences(trainerExperiencesCopy);
                               }}/>
                </Grid>
                <Grid item xs={12} md={6}>
                    <TextField
                        required
                        id="xxxxx"
                        label="miejsce pracy"
                        fullWidth
                        value={props.trainerExperiences[1].workLocation}
                        onChange={event => {
                            const trainerExperiencesCopy = props.trainerExperiences.map(newValues => {
                                return {...newValues};
                            });
                            trainerExperiencesCopy[1].workLocation = event.target.value;
                            props.setTrainerExperiences(trainerExperiencesCopy);
                        }}
                    />
                </Grid>
                <Grid item xs={12} md={12}>
                    <TextField
                        required
                        id="xxxxx"
                        label="opis"
                        fullWidth
                        multiline
                        rows={3}
                        value={props.trainerExperiences[1].description}
                        onChange={event => {
                            const trainerExperiencesCopy = props.trainerExperiences.map(newValues => {
                                return {...newValues};
                            });
                            trainerExperiencesCopy[1].description = event.target.value;
                            props.setTrainerExperiences(trainerExperiencesCopy);
                        }}
                    />
                </Grid>

                <Grid item xs={12} md={12}>
                    <Divider variant="middle"/>
                </Grid>

                <Grid item xs={12} md={6}>
                    <TextField required id="date1" label="od - do" fullWidth
                               value={props.trainerExperiences[2].dateFrame}
                               onChange={event => {
                                   const trainerExperiencesCopy = props.trainerExperiences.map(newValues => {
                                       return {...newValues};
                                   });
                                   trainerExperiencesCopy[2].dateFrame = event.target.value;
                                   props.setTrainerExperiences(trainerExperiencesCopy);
                               }}
                    />
                </Grid>
                <Grid item xs={12} md={6}>
                    <TextField
                        required
                        id="xxxxx"
                        label="miejsce pracy"
                        fullWidth
                        value={props.trainerExperiences[2].workLocation}
                        onChange={event => {
                            const trainerExperiencesCopy = props.trainerExperiences.map(newValues => {
                                return {...newValues};
                            });
                            trainerExperiencesCopy[2].workLocation = event.target.value;
                            props.setTrainerExperiences(trainerExperiencesCopy);
                        }}
                    />
                </Grid>
                <Grid item xs={12} md={12}>
                    <TextField
                        required
                        id="xxxxx"
                        label="opis"
                        fullWidth
                        multiline
                        rows={3}
                        value={props.trainerExperiences[2].description}
                        onChange={event => {
                            const trainerExperiencesCopy = props.trainerExperiences.map(newValues => {
                                return {...newValues};
                            });
                            trainerExperiencesCopy[2].description = event.target.value;
                            props.setTrainerExperiences(trainerExperiencesCopy);
                        }}
                    />
                </Grid>
            </Grid>

            <Typography variant="h6" gutterBottom>
                Wykształcenie
            </Typography>
            <Grid container spacing={3}>
                <Grid item xs={12} md={6}>
                    <TextField required id="date1" label="od - do" fullWidth
                               value={props.trainerEducations[0].dateFrame}
                               onChange={event => {
                                   const trainerEducationsCopy = props.trainerEducations.map(newValues => {
                                       return {...newValues};
                                   });
                                   trainerEducationsCopy[0].dateFrame = event.target.value;
                                   props.setTrainerEducations(trainerEducationsCopy);
                               }}/>
                </Grid>
                <Grid item xs={12} md={6}>
                    <TextField
                        required
                        id="xxxxx"
                        label="szkoła"
                        fullWidth
                        value={props.trainerEducations[0].schoolName}
                        onChange={event => {
                            const trainerEducationsCopy = props.trainerEducations.map(newValues => {
                                return {...newValues};
                            });
                            trainerEducationsCopy[0].schoolName = event.target.value;
                            props.setTrainerEducations(trainerEducationsCopy);
                        }}
                    />
                </Grid>

                <Grid item xs={12} md={12}>
                    <Divider variant="middle"/>
                </Grid>

                <Grid item xs={12} md={6}>
                    <TextField required id="date1" label="od - do" fullWidth
                               value={props.trainerEducations[1].dateFrame}
                               onChange={event => {
                                   const trainerEducationsCopy = props.trainerEducations.map(newValues => {
                                       return {...newValues};
                                   });
                                   trainerEducationsCopy[1].dateFrame = event.target.value;
                                   props.setTrainerEducations(trainerEducationsCopy);
                               }}/>
                </Grid>
                <Grid item xs={12} md={6}>
                    <TextField
                        required
                        id="xxxxx"
                        label="szkoła"
                        fullWidth
                        value={props.trainerEducations[1].schoolName}
                        onChange={event => {
                            const trainerEducationsCopy = props.trainerEducations.map(newValues => {
                                return {...newValues};
                            });
                            trainerEducationsCopy[1].schoolName = event.target.value;
                            props.setTrainerEducations(trainerEducationsCopy);
                        }}
                    />
                </Grid>

                <Grid item xs={12} md={12}>
                    <Divider variant="middle"/>
                </Grid>

                <Grid item xs={12} md={6}>
                    <TextField required id="date1" label="od - do"
                               fullWidth
                               value={props.trainerEducations[2].dateFrame}
                               onChange={event => {
                                   const trainerEducationsCopy = props.trainerEducations.map(newValues => {
                                       return {...newValues};
                                   });
                                   trainerEducationsCopy[2].dateFrame = event.target.value;
                                   props.setTrainerEducations(trainerEducationsCopy);
                               }}/>
                </Grid>
                <Grid item xs={12} md={6}>
                    <TextField
                        required
                        id="xxxxx"
                        label="szkoła"
                        fullWidth
                        value={props.trainerEducations[2].schoolName}
                        onChange={event => {
                            const trainerEducationsCopy = props.trainerEducations.map(newValues => {
                                return {...newValues};
                            });
                            trainerEducationsCopy[2].schoolName = event.target.value;
                            props.setTrainerEducations(trainerEducationsCopy);
                        }}
                    />
                </Grid>

                <Grid item xs={12} md={12}>
                    <Divider variant="middle"/>
                </Grid>
            </Grid>

            <Typography variant="h6" gutterBottom>
                Certyfikaty
            </Typography>
            <Grid container spacing={3}>

                <Grid item xs={12} md={12}>
                    <TextField
                        required
                        id="xxxxx"
                        label="certyfikat/miejsce/opis"
                        fullWidth
                        multiline
                        rows={2}
                        value={props.trainerCertificates[0].description}
                        onChange={event => {
                            const trainerCertificatesCopy = props.trainerCertificates.map(newValues => {
                                return {...newValues};
                            });
                            trainerCertificatesCopy[0].description = event.target.value;
                            props.setTrainerCertificates(trainerCertificatesCopy);
                        }}
                    />
                </Grid>

                <Grid item xs={12} md={12}>
                    <Divider variant="middle"/>
                </Grid>

                <Grid item xs={12} md={12}>
                    <TextField
                        required
                        id="xxxxx"
                        label="certyfikat/miejsce/opis"
                        fullWidth
                        multilines
                        rows={2}
                        value={props.trainerCertificates[1].description}
                        onChange={event => {
                            const trainerCertificatesCopy = props.trainerCertificates.map(newValues => {
                                return {...newValues};
                            });
                            trainerCertificatesCopy[1].description = event.target.value;
                            props.setTrainerCertificates(trainerCertificatesCopy);
                        }}
                    />
                </Grid>

                <Grid item xs={12} md={12}>
                    <Divider variant="middle"/>
                </Grid>


                <Grid item xs={12} md={12}>
                    <TextField
                        required
                        id="xxxxx"
                        label="certyfikat/miejsce/opis"
                        fullWidth
                        multiline
                        rows={2}
                        value={props.trainerCertificates[2].description}
                        onChange={event => {
                            const trainerCertificatesCopy = props.trainerCertificates.map(newValues => {
                                return {...newValues};
                            });
                            trainerCertificatesCopy[2].description = event.target.value;
                            props.setTrainerCertificates(trainerCertificatesCopy);
                        }}
                    />
                </Grid>

                <Grid item xs={12} md={12}>
                    <Divider variant="middle"/>
                </Grid>
            </Grid>

        </React.Fragment>
    );
}