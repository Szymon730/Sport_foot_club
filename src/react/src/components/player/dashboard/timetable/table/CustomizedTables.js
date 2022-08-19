import React, {useState} from 'react';
import {makeStyles, withStyles} from '@material-ui/core/styles';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableContainer from '@material-ui/core/TableContainer';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Paper from '@material-ui/core/Paper';
import IconButton from "@material-ui/core/IconButton";
import CheckIcon from '@material-ui/icons/Check';
import MuiAlert from '@material-ui/lab/Alert';
import {Snackbar} from "@material-ui/core";
import axios from "axios";

const StyledTableCell = withStyles((theme) => ({
    head: {
        backgroundColor: theme.palette.common.black,
        color: theme.palette.common.white,
    },
    body: {
        fontSize: 14,
    },
}))(TableCell);

const StyledTableRow = withStyles((theme) => ({
    root: {
        '&:nth-of-type(odd)': {
            backgroundColor: theme.palette.action.hover,
        },
    },
}))(TableRow);

const useStyles = makeStyles({
    table: {
        minWidth: 700,
    },
});

export default function CustomizedTables(props) {
    const classes = useStyles();

    const [openConfirmSnackBar, setOpenConfirmSnackBar] = useState(false);


    const handleConfirmClick = (eventCode) => {
        axios.put(`/event/${eventCode}/confirm/attendance`)
            .then(value => {
                props.fetchData();
            })
        setOpenConfirmSnackBar(true);
    };

    const handleCloseTimeout = () => {
        setTimeout(() => {
            setOpenConfirmSnackBar(false);
        }, 3000)
    };

    const handleClose = () => {
        setOpenConfirmSnackBar(false);
    };

    return (<>
            <TableContainer component={Paper}>
                <Table className={classes.table} aria-label="customized table">
                    <TableHead>
                        <TableRow>
                            <StyledTableCell>Kategoria</StyledTableCell>
                            <StyledTableCell align="right">data</StyledTableCell>
                            <StyledTableCell align="right">opis</StyledTableCell>
                            <StyledTableCell align="right">miejsce</StyledTableCell>
                            <StyledTableCell align="right">Rozmiar druzyny</StyledTableCell>
                            <StyledTableCell align="right">-</StyledTableCell>
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {props.events.map((row) => <TableRowWithCollapse
                            handleConfirmClick={() => handleConfirmClick(row.eventCode)}
                            key={row.eventCode}
                            row={row}/>)}
                    </TableBody>
                </Table>
            </TableContainer>

            <Snackbar open={openConfirmSnackBar}
                      onClose={handleCloseTimeout}>
                <Alert onClose={handleClose} severity="success">
                    Udział w wydarzeniu potwierdzony
                </Alert>
            </Snackbar>
        </>
    );
}


function Alert(props) {
    return <MuiAlert elevation={6} variant="filled" {...props} />;
}

const TableRowWithCollapse = ({row, handleConfirmClick}) => {


    return <>
        <StyledTableRow key={row.category}>
            <StyledTableCell component="th" scope="row">{row.category}</StyledTableCell>
            <StyledTableCell align="right">{row.dateTime.replace("T", " ")}</StyledTableCell>
            <StyledTableCell align="right">{row.description}</StyledTableCell>
            <StyledTableCell align="right">{row.eventLocation}</StyledTableCell>
            <StyledTableCell align="right">{row.teamSize}</StyledTableCell>
            <StyledTableCell align="right">
                {!row.selectedPlayers[0].confirmedAttendance &&
                <IconButton edge="end" aria-label="delete"
                            onClick={() => {
                                handleConfirmClick()
                            }}>
                    <CheckIcon/>
                </IconButton>}
            </StyledTableCell>

        </StyledTableRow>
    </>
}