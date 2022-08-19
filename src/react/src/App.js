import './App.css';
import {BrowserRouter as Router, Redirect, Route, Switch} from "react-router-dom";
import SignUp from "./components/auth/signup/SignUp";
import SignIn from "./components/auth/signin/SignIn";
import Navbar from "./components/navbar/Navbar";
import React, {useRef, useState} from "react";
import Home from "./components/home/Home";
import Dashboard from "./components/trainer/dashboard/TrainerPane";
import TrainerProfile from "./components/trainer/profile/TrainerProfile";
import axios from "axios";
import {parseJwt} from "./utils/parseJwt";
import {CircularProgress} from "@material-ui/core";
import {createStyles, makeStyles} from '@material-ui/core/styles';
import PlayerDashboard from "./components/player/dashboard/PlayerDashboard";


const useStyles = makeStyles((theme) =>
    createStyles({
        root: {
            position: "absolute",
            left: "50%",
            top: "50%",
            transform: "translate(-50%, -50%)",
            padding: "10px",
            '& > * + *': {
                marginLeft: theme.spacing(2),
            },
        },
    }),
);

function App() {

    const classes = useStyles();

    const [isAuthenticated, setIsAuthenticated] = useState(false);
    const authenticationRef = useRef(null);
    const [user, setUser] = useState(null);
    const [loading, setLoading] = useState(true);

    React.useEffect(() => {
        const token = localStorage.getItem("token");
        if (token) {
            setIsAuthenticated(true);
            authenticationRef.current = axios.interceptors.request.use(req => {
                req.headers.Authorization = token;
                return req;
            });
            setUser(parseJwt(token));
        }
        setLoading(false);
    }, []);

    return (
        <>
            {loading ?
                <div className={classes.root}>
                    <CircularProgress size={100}/>
                </div> :
                <Router>
                    <Navbar authenticationRef={authenticationRef} isAuthenticated={isAuthenticated}
                            setIsAuthenticated={setIsAuthenticated}
                            user={user}
                    />
                    <Switch>
                        <Route path="/auth/login">
                            {isAuthenticated ? <Redirect to={"/"}/> :
                                <SignIn authenticationRef={authenticationRef} setIsAuthenticated={setIsAuthenticated}
                                        setUser={setUser}/>}
                        </Route>
                        <Route path="/auth/register">
                            {isAuthenticated ? <Redirect to={"/"}/> : <SignUp/>}
                        </Route>
                        {user?.isTrainer &&
                        <Route path="/trainer/dashboard">
                            <Dashboard/>
                        </Route>}
                        {user?.isTrainer &&
                        <Route path="/trainer/profile">
                            <TrainerProfile/>
                        </Route>}
                        {user?.isPlayer &&
                        <Route path="/player/dashboard">
                            <PlayerDashboard/>
                        </Route>}
                        <Route path="/">
                            <Home/>
                        </Route>
                    </Switch>
                </Router>
            }
        </>
    );
}

export default App;
