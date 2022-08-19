import Container from "@material-ui/core/Container";
import React from "react";
import {makeStyles} from "@material-ui/core/styles";
import Grid from "@material-ui/core/Grid";
import Paper from "@material-ui/core/Paper";
import PlayersTable from "./playersTable/PlayersTable"
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
    const [openAddPlayerDialog, setOpenAddPlayerDialog] = React.useState(false);
    const [players, setPlayers] = React.useState([]);


    const fetchPlayers = () => {
        axios.get("/players")
            .then(response => {
                const data = response.data;
                setPlayers(data);
                setOpenAddPlayerDialog(false);
            });
    }

    const handleCloseAddPlayerDialog = () => {
        setOpenAddPlayerDialog(false);
    };


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
                            <PlayersTable
                                handleCloseAddPlayerDialog={handleCloseAddPlayerDialog}
                                openAddPlayerDialog={openAddPlayerDialog}
                                players={players}
                                fetchPlayers={fetchPlayers}
                            />
                        </Paper>
                    </Grid>
                </Grid>
            </Container>
        </>);
}