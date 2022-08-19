import Typography from "@material-ui/core/Typography";
import Container from "@material-ui/core/Container";
import Grid from "@material-ui/core/Grid";
import React, {useEffect, useState} from "react";
import {makeStyles} from "@material-ui/core/styles";
import clsx from "clsx";
import axios from "axios";
import UsersTable from "./users/UsersTable";
import {Paper} from "@material-ui/core";


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
        height: 400,
    },
}));

export default function Dashboard(props) {
    const classes = useStyles();
    const fixedHeightPaper = clsx(classes.paper, classes.fixedHeight);
    const [trainerName, setTrainerName] = useState("");

    useEffect(() => {
        axios.get("/trainer/profile")
            .then(response => {
                const data = response.data;
                setTrainerName(data.name + " " + data.lastName);
            })
            .catch(reason => {
                setTrainerName("Proszę dodaj informacje przez Profil Trenera");
            });
    }, [])

    return (
        <>
            <Typography variant="h6" gutterBottom>
                Witaj trenerze: {trainerName}
            </Typography>
            <div className={classes.appBarSpacer}/>
            <Container maxWidth="lg" className={classes.container}>
                <Grid container spacing={3}>
                    {/* Chart */}
                    <Grid item>
                        {/*<Paper className={fixedHeightPaper}>*/}
                        {/*    /!*<Chart/>*!/*/}
                        {/*    /!*<PlannedEvents/>*!/*/}
                        {/*</Paper>*/}
                    </Grid>
                    {/* Recent Deposits */}
                    <Grid item>
                        {/*<Paper className={fixedHeightPaper}>*/}
                        {/*    <Deposits/>*/}
                        {/*</Paper>*/}
                        {/*<Paper className={fixedHeightPaper}>*/}
                        {/*    /!*<Chart/>*!/*/}
                        {/*    /!*<PlannedEvents/>*!/*/}
                        {/*</Paper>*/}
                    </Grid>
                    <Grid item xs={12}>
                        <Paper className={classes.paper}>
                            <UsersTable />
                        </Paper>
                    </Grid>
                </Grid>
            </Container>
        </>);
}