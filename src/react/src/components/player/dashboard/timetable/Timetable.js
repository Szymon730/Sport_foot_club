import Container from "@material-ui/core/Container";
import React from "react";
import {makeStyles} from "@material-ui/core/styles";
import clsx from "clsx";
import CustomizedTables from "./table/CustomizedTables";
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

export default function Timetable(props) {
    const classes = useStyles();
    const fixedHeightPaper = clsx(classes.paper, classes.fixedHeight);
    const [events, setEvents] = React.useState([]);


    const fetchData = () => {
        axios.get("/events")
            .then(data => {
                console.log(data.data.events)
                setEvents(data.data.events)
            }).catch(reason => {
            console.log(reason)
        })
    }

    React.useEffect(() => {
        fetchData();
    }, []);


    return (
        <>
            <div className={classes.appBarSpacer}/>
            <Container maxWidth="lg" className={classes.container}>
                Terminarz
                <CustomizedTables events={events} fetchData={fetchData}/>
            </Container>
        </>);
}