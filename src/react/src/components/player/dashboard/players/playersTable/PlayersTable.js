import React, {useState} from 'react';
import PropTypes from 'prop-types';
import {makeStyles} from '@material-ui/core/styles';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableContainer from '@material-ui/core/TableContainer';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Button from "@material-ui/core/Button";
import axios from "axios";

const useRowStyles = makeStyles({
    root: {
        '& > *': {
            borderBottom: 'unset',
        },
    },
});

const PLAYER_STATUS = {
    MAIN_TEAM: "Główny skład",
    MAIN_TEAM_BENCH: "Ławka rezerwowych",
    RESERVES: "Rezerwy",
    INJURED: "Kontuzjowany",
    BLOCKED: "Zawieszony"
}

const useStyles = makeStyles((theme) => ({
    formControl: {
        margin: theme.spacing(1),
        minWidth: 120,
    },
    selectEmpty: {
        marginTop: theme.spacing(2),
    },
}));

function Row(props) {
    const {row} = props;
    const classes = useRowStyles();

    let statusButtonColor;
    if (row.playerStatus === "MAIN_TEAM" || row.playerStatus === "MAIN_TEAM_BENCH") {
        statusButtonColor = "primary";
    } else {
        statusButtonColor = "secondary";
    }

    return (
        <React.Fragment>
            <TableRow className={classes.root}>
                <TableCell component="th" scope="row">
                    {row.name}
                </TableCell>
                <TableCell align="right">{row.lastName}</TableCell>
                <TableCell align="right">{row.birthDate}</TableCell>
                <TableCell align="right">{row.position}</TableCell>
                <TableCell align="right">{row.email}</TableCell>
                <TableCell align="right">
                    <Button variant="contained"
                            color={statusButtonColor}
                    >
                        {PLAYER_STATUS[row.playerStatus]}
                    </Button>
                </TableCell>
            </TableRow>
        </React.Fragment>
    );
}

Row.propTypes = {
    row: PropTypes.shape({
        calories: PropTypes.number.isRequired,
        carbs: PropTypes.number.isRequired,
        fat: PropTypes.number.isRequired,
        history: PropTypes.arrayOf(
            PropTypes.shape({
                amount: PropTypes.number.isRequired,
                customerId: PropTypes.string.isRequired,
                date: PropTypes.string.isRequired,
            }),
        ).isRequired,
        name: PropTypes.string.isRequired,
        price: PropTypes.number.isRequired,
        protein: PropTypes.number.isRequired,
    }).isRequired,
};

export default function PlayersTable(props) {


    const classes = useStyles();


    return (
        <TableContainer>
            <Table aria-label="collapsible table">
                <TableHead>
                    <TableRow>
                        <TableCell>Imię</TableCell>
                        <TableCell align="right">Nazwisko</TableCell>
                        <TableCell align="right">Data urodzenia</TableCell>
                        <TableCell align="right">Pozycja na boisku</TableCell>
                        <TableCell align="right">adres email</TableCell>
                        <TableCell align="right">-</TableCell>

                    </TableRow>
                </TableHead>
                <TableBody>
                    {props.players.map((player) => (
                        <Row key={player.name}
                             row={player}
                             handleClickOpenEditPlayerDialog={props.handleClickOpenEditPlayerDialog}
                             deletePlayer={props.deletePlayer}
                        />
                    ))}
                </TableBody>
            </Table>
        </TableContainer>
    );
}