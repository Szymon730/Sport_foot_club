import Container from "@material-ui/core/Container";
import React from "react";
import {makeStyles} from "@material-ui/core/styles";
import clsx from "clsx";
import FormControl from "@material-ui/core/FormControl";
import InputLabel from "@material-ui/core/InputLabel";
import Select from "@material-ui/core/Select";
import MenuItem from "@material-ui/core/MenuItem";
import Typography from "@material-ui/core/Typography";
import Grid from "@material-ui/core/Grid";
import Paper from "@material-ui/core/Paper";
import TextField from '@material-ui/core/TextField';
import NewLocationDialog from "./newLocationDialog/NewLocationDialog";
import Fab from "@material-ui/core/Fab";
import AddIcon from "@material-ui/icons/Add";
import {Snackbar} from "@material-ui/core";
import * as PropTypes from "prop-types";
import axios from "axios";
import PlayersSelectionDialog from "./playersSelectionDialog/PlayersSelectionDialog";


const useStyles = makeStyles((theme) => ({
    root: {
        flexGrow: 1
    },
    appBarSpacer: theme.mixins.toolbar,
    content: {
        flexGrow: 1,
        height: '100vh',
        overflow: 'auto',
    },
    container: {
        paddingTop: theme.spacing(4),
        paddingBottom: theme.spacing(4),
    },
    fixedHeight: {
        height: 240,
    },
    formControl: {
        margin: theme.spacing(1),
        minWidth: 120,
    },
    paper: {
        width: "1000px",
        padding: theme.spacing(2),
        textAlign: "center",
        color: theme.palette.text.secondary
    },
    textField: {
        marginLeft: theme.spacing(1),
        marginRight: theme.spacing(1),
        width: 200,
    },
}));

function MuiAlert(props) {
    return null;
}

MuiAlert.propTypes = {
    elevation: PropTypes.number,
    variant: PropTypes.string
};

function Alert(props) {
    return <MuiAlert elevation={6} variant="filled" {...props} />;
}


export default function Events(props) {
    const classes = useStyles();
    const fixedHeightPaper = clsx(classes.paper, classes.fixedHeight);

    const [category, setCategory] = React.useState('');
    const [teamSize, setTeamSize] = React.useState('');
    const [locationId, setLocationId] = React.useState('');
    const [description, setDescription] = React.useState('');
    const [dateTime, setDateTime] = React.useState('');

    const [showNotification, setShowNotification] = React.useState(false);

    const [availableLocations, setAvailableLocations] = React.useState([])
    const [availablePlayers, setAvailablePlayers] = React.useState([])
    const [selectedPlayers, setSelectedPlayers] = React.useState([])


    const handleChangeCategory = (event) => {
        setCategory(event.target.value);
    };

    const handleChangeLocation = (event) => {
        setLocationId(event.target.value);
    };

    const handleChangeTeamSize = (event) => {
        setTeamSize(event.target.value);
    };

    const fetchAvailableLocations = () => {
        axios.get("/eventLocations")
            .then(response => {
                const data = response.data;
                setAvailableLocations(data.eventLocations);
            })
            .catch(reason => {
                console.log(reason)
            })
    }

    const fetchAvailablePlayers = () => {
        axios.get("/players")
            .then(response => {
                console.log(response.data);
                const data = response.data;
                setAvailablePlayers(data);
            });
    }

    const addNewEvent = () => {
        const addEventRequest = {
            category, teamSize, locationId, description, dateTime, selectedPlayers
        }
        console.log(addEventRequest);
        axios.post("/event/create", addEventRequest)
            .then(response => {
                const data = response.data;
                setShowNotification(true);
            })


    }

    React.useEffect(() => {
        fetchAvailableLocations();
        fetchAvailablePlayers();
    }, [])

    return (
        <>
            <div className={classes.appBarSpacer}/>
            <Typography variant={"h4"}>Dodaj wydarzenie</Typography>
            {/*Kategoria - dropdown - mecz, mecz towarzyski, mecz ligowy - trening*/}
            <Container maxWidth="lg" className={classes.container}>
                <Paper className={classes.paper}>
                    <div className={classes.root}>

                        <Grid container spacing={2}>
                            <Grid item xs={12} sm={4}>
                                <Typography variant={"h6"}>Kategoria</Typography>

                            </Grid>

                            <Grid item xs={12} sm={5}>

                                <FormControl className={classes.formControl}>
                                    <InputLabel id="demo-simple-select-label">Kategoria</InputLabel>
                                    <Select
                                        labelId="demo-simple-select-label"
                                        id="demo-simple-select"
                                        value={category}
                                        onChange={handleChangeCategory}
                                        className={classes.textField}
                                    >
                                        <MenuItem value={"mecz"}>mecz</MenuItem>
                                        <MenuItem value={"mecz towarzyski"}>mecz towarzyski</MenuItem>
                                        <MenuItem value={"mecz ligowy"}>mecz ligowy</MenuItem>
                                        <MenuItem value={"trening"}>trening</MenuItem>
                                    </Select>
                                </FormControl>
                            </Grid>

                            <Grid item xs={12} sm={3}>
                            </Grid>
                        </Grid>

                        <Grid container spacing={2}>
                            <Grid item xs={12} sm={4}>
                                <Typography variant={"h6"}>Rozmiar zespołu</Typography>

                            </Grid>

                            <Grid item xs={12} sm={5}>

                                <FormControl className={classes.formControl}>
                                    <InputLabel id="demo-simple-select-label">Zespół</InputLabel>
                                    <Select
                                        labelId="demo-simple-select-label"
                                        id="demo-simple-select"
                                        value={teamSize}
                                        className={classes.textField}
                                        onChange={handleChangeTeamSize}>

                                        <MenuItem value={5}>5</MenuItem>
                                        <MenuItem value={7}>7</MenuItem>
                                        <MenuItem value={9}>9</MenuItem>
                                        <MenuItem value={11}>11</MenuItem>
                                        <MenuItem value={16}>16</MenuItem>
                                        <MenuItem value={21}>21</MenuItem>
                                    </Select>
                                </FormControl>
                            </Grid>

                            <Grid item xs={12} sm={3}>
                            </Grid>
                        </Grid>

                        <Grid container spacing={2}>
                            <Grid item xs={12} sm={4}>
                                <Typography variant={"h6"}>Opis</Typography>
                            </Grid>

                            <Grid item xs={12} sm={5}>
                                <FormControl className={classes.formControl}>
                                    <TextField
                                        id="standard-full-width"
                                        label="Opis"
                                        style={{margin: 8}}
                                        placeholder="Opis"
                                        fullWidth
                                        margin="normal"
                                        InputLabelProps={{
                                            shrink: true,
                                        }}
                                        className={classes.textField}
                                        multiline
                                        value={description}
                                        onChange={(e) => {
                                            setDescription(e.target.value)
                                        }}
                                    />
                                </FormControl>
                            </Grid>

                            <Grid item xs={12} sm={3}>
                            </Grid>
                        </Grid>

                        <Grid container spacing={2}>
                            <Grid item xs={12} sm={4}>
                                <Typography variant={"h6"}>Dzień i godzina</Typography>
                            </Grid>

                            <Grid item xs={12} sm={5}>
                                <FormControl className={classes.formControl}>
                                    <TextField
                                        id="datetime-local"
                                        label="Następne wydarzenie"
                                        type="datetime-local"
                                        className={classes.textField}
                                        InputLabelProps={{
                                            shrink: true,
                                        }}
                                        value={dateTime}
                                        onChange={(e) => {
                                            setDateTime(e.target.value);
                                        }}
                                    />
                                </FormControl>
                            </Grid>

                            <Grid item xs={12} sm={3}>
                            </Grid>
                        </Grid>

                        <Grid container spacing={2}>
                            <Grid item xs={12} sm={4}>
                                <Typography variant={"h6"}>Miejsce spotkania</Typography>
                            </Grid>

                            <Grid item xs={12} sm={5}>
                                <FormControl className={classes.formControl}>
                                    <FormControl className={classes.formControl}>
                                        <InputLabel id="demo-simple-select-label">miejsce spotkania</InputLabel>
                                        <Select
                                            labelId="demo-simple-select-label"
                                            id="demo-simple-select"
                                            value={locationId}
                                            onChange={handleChangeLocation}
                                            className={classes.textField}
                                        >
                                            {availableLocations.map(availableLocations => {
                                                return (
                                                    <MenuItem key={availableLocations.id} value={availableLocations.id}>
                                                        {availableLocations.name}
                                                    </MenuItem>)
                                            })}
                                        </Select>
                                        <NewLocationDialog fetchLocations={fetchAvailableLocations}/>
                                    </FormControl>
                                </FormControl>
                            </Grid>
                        </Grid>

                        <Grid container spacing={2}>
                            <Grid item xs={12} sm={4}>
                                <Typography variant={"h6"}>Zawodnicy</Typography>
                            </Grid>

                            <Grid item xs={12} sm={5}>
                                <FormControl className={classes.formControl}>
                                    <PlayersSelectionDialog availablePlayers={availablePlayers}
                                                            setAvailablePlayers={setAvailablePlayers}
                                                            selectedPlayers={selectedPlayers }
                                                            setSelectedPlayers={setSelectedPlayers}
                                                            teamSize={teamSize}
                                    />
                                </FormControl>

                            </Grid>

                            <Grid item xs={12} sm={3}>
                                <Fab color="primary" aria-label="add"
                                     onClick={() => addNewEvent()}>
                                    <AddIcon/>
                                </Fab>
                            </Grid>

                        </Grid>

                    </div>
                </Paper>


                <Snackbar
                    anchorOrigin={{vertical: 'top', horizontal: 'center'}}
                    open={showNotification}
                    onClose={() => setShowNotification(false)}
                    message="Dodano wydarzenie"
                    autoHideDuration={6000}
                />

            </Container>
        </>);
}