import AppBar from "@material-ui/core/AppBar";
import Toolbar from "@material-ui/core/Toolbar";
import IconButton from "@material-ui/core/IconButton";
import MenuIcon from "@material-ui/icons/Menu";
import Typography from "@material-ui/core/Typography";
import {Link, useHistory} from "react-router-dom";
import Button from "@material-ui/core/Button";
import makeStyles from "@material-ui/core/styles/makeStyles";
import React from "react";
import axios from "axios";

const useStyles = makeStyles((theme) => ({
    menuButton: {
        marginRight: theme.spacing(2),
    },
    title: {
        flexGrow: 1,
    },
}));


const Navbar = (props) => {
    const classes = useStyles();
    const history = useHistory();

    const logout = () => {
        localStorage.removeItem("token");
        axios.interceptors.request.eject(props.authenticationRef.current)
        props.setIsAuthenticated(false)
        history.push("/")
    }

    return (
        <AppBar position="static">
            <Toolbar>
                <IconButton edge="start"
                            className={classes.menuButton}
                            color="inherit" aria-label="menu">
                    <MenuIcon/>
                </IconButton>
                <Typography variant="h6" className={classes.title}>
                    <Button component={Link} to="/" color="inherit">
                        APP
                    </Button>
                </Typography>
                {props.isAuthenticated && <>
                    {props.user?.isTrainer &&
                    <>
                        <Button component={Link} to="/trainer/profile" color="inherit">
                            Profil trenera
                        </Button>
                        <Button component={Link} to="/trainer/dashboard" color="inherit">
                            Panel Trenera
                        </Button>
                    </>}
                    {props.user?.isPlayer &&
                    <>
                        <Button component={Link} to="/player/dashboard" color="inherit">
                            Panel Zawodnika
                        </Button>
                    </>}
                    <Button color="inherit" onClick={logout}>
                        Wyloguj
                    </Button>
                </>}
                {!props.isAuthenticated && <>
                    <Button component={Link} to="/auth/login" color="inherit">
                        Zaloguj
                    </Button>
                    <Button component={Link} to="/auth/register" color="inherit">
                        Zarejestruj
                    </Button>
                </>}


            </Toolbar>
        </AppBar>)
}

export default Navbar;