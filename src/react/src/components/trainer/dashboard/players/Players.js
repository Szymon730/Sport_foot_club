import Container from "@material-ui/core/Container";
import React from "react";
import {makeStyles} from "@material-ui/core/styles";
import clsx from "clsx";
import Grid from "@material-ui/core/Grid";
import Paper from "@material-ui/core/Paper";
import PlayersTable from "./playersTable/PlayersTable"
import AddEditPlayerDialog from "./addEditPlayerDialog/AddEditPlayerDialog";
import DeleteDialog from "./deleteDialog/DeleteDialog";
import axios from "axios";

const useStyles = makeStyles((theme) => ({
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
    paper: {
        padding: theme.spacing(2),
        display: 'flex',
        overflow: 'auto',
        flexDirection: 'column',
    },
    fixedHeight: {
        height: 240,
    },
}));

export default function Players(props) {
    const classes = useStyles();
    const fixedHeightPaper = clsx(classes.paper, classes.fixedHeight);

    const [openAddPlayerDialog, setOpenAddPlayerDialog] = React.useState(false);
    const [players, setPlayers] = React.useState([]);

    const [name, setName] = React.useState("");
    const [lastName, setLastName] = React.useState("");
    const [birthDate, setBirthDate] = React.useState("");
    const [email, setEmail] = React.useState("");
    const [position, setPosition] = React.useState("");

    const [addFlow, setAddFlow] = React.useState(true);

    const [openDeleteDialog, setOpenDeleteDialog] = React.useState(false);
    const [deletingPlayerEmail, setDeletingPlayerEmail] = React.useState(null);

    // const [players, setOPlayers] = React.useState([]);

    const fetchPlayers = () => {
        axios.get("/players")
            .then(response => {
                const data = response.data;
                setPlayers(data);
                setOpenAddPlayerDialog(false);
            });
    }


    const handleClickOpenAddPlayerDialog = () => {
        setAddFlow(true);
        setName("");
        setLastName("");
        setBirthDate("");
        setEmail("");
        setPosition("");
        setOpenAddPlayerDialog(true);
    };

    const handleClickOpenEditPlayerDialog = (player) => {
        console.log(player);
        setAddFlow(false);
        setName(player.name);
        setLastName(player.lastName);
        setBirthDate(player.birthDate);
        setEmail(player.email);
        setPosition(player.position);
        setOpenAddPlayerDialog(true);
    };

    const handleCloseAddPlayerDialog = () => {
        setOpenAddPlayerDialog(false);
    };

    const savePlayer = () => {
        const requestObject = {
            name: name,
            lastName: lastName,
            birthDate: birthDate,
            email: email,
            position: position,
        }
        console.log(requestObject);
        const request = addFlow ? axios.post("/player", requestObject) : axios.put("/player", requestObject);
        request.then(_ => {
            fetchPlayers();
        })
    }
    const deletePlayer = (email) => {
        setDeletingPlayerEmail(email);
        setOpenDeleteDialog(true);
    }

    const deletePlayerConfirmed = () => {
        const requestObject = {
            email: deletingPlayerEmail
        }
        console.log(requestObject);
        axios.delete("/player", {data: requestObject})
            .then(_ => {
                fetchPlayers();
                setOpenDeleteDialog(false);
            });
    }


    React.useEffect(() => {
        fetchPlayers();
    }, [])

    return (
        <>
            <div className={classes.appBarSpacer}/>
            <Container maxWidth="lg" className={classes.container}>
                Zawodnicy
                <Grid container spacing={3}>
                    <Grid item xs={12}>
                        <Paper className={classes.paper}>
                            <PlayersTable handleClickOpenAddPlayerDialog={handleClickOpenAddPlayerDialog}
                                          handleCloseAddPlayerDialog={handleCloseAddPlayerDialog}
                                          openAddPlayerDialog={openAddPlayerDialog}
                                          players={players}
                                          handleClickOpenEditPlayerDialog={handleClickOpenEditPlayerDialog}
                                          deletePlayer={deletePlayer}
                                          fetchPlayers={fetchPlayers}
                            />
                        </Paper>
                    </Grid>
                </Grid>
                <AddEditPlayerDialog handleClickOpenAddPlayerDialog={handleClickOpenAddPlayerDialog}
                                     handleCloseAddPlayerDialog={handleCloseAddPlayerDialog}
                                     openAddPlayerDialog={openAddPlayerDialog}
                                     setName={setName}
                                     setLastName={setLastName}
                                     setBirthDate={setBirthDate}
                                     setEmail={setEmail}
                                     setPosition={setPosition}
                                     name={name}
                                     lastName={lastName}
                                     birthDate={birthDate}
                                     email={email}
                                     position={position}
                                     savePlayer={savePlayer}
                                     addFlow={addFlow}
                />
                <DeleteDialog openDeleteDialog={openDeleteDialog} setOpenDeleteDialog={setOpenDeleteDialog}
                              deletePlayerConfirmed={deletePlayerConfirmed}/>
            </Container>
        </>);
}