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
import DeleteIcon from "@material-ui/icons/Delete";
import EditIcon from "@material-ui/icons/Edit";
import {Collapse} from "@material-ui/core";
import Box from "@material-ui/core/Box";
import Typography from "@material-ui/core/Typography";
import ExpandMoreIcon from '@material-ui/icons/ExpandMore';
import ExpandLessIcon from '@material-ui/icons/ExpandLess';
import translatePlayerStatus from "../../../../../utils/playerStatusTranslations";
import CheckIcon from '@material-ui/icons/Check';
import ClearIcon from '@material-ui/icons/Clear';

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

    return (
        <TableContainer component={Paper}>
            <Table className={classes.table} aria-label="customized table">
                <TableHead>
                    <TableRow>
                        <StyledTableCell/>
                        <StyledTableCell>Kategoria</StyledTableCell>
                        <StyledTableCell align="right">data</StyledTableCell>
                        <StyledTableCell align="right">opis</StyledTableCell>
                        <StyledTableCell align="right">miejsce</StyledTableCell>
                        <StyledTableCell align="right">Rozmiar druzyny</StyledTableCell>
                        <StyledTableCell align="right">-</StyledTableCell>
                    </TableRow>
                </TableHead>
                <TableBody>
                    {props.events.map((row) => <TableRowWithCollapse key={row.category} row={row}
                                                                     handleDeleteRow={props.handleDeleteRow}/>
                    )}
                </TableBody>
            </Table>
        </TableContainer>
    );
}


const TableRowWithCollapse = ({row, handleDeleteRow}) => {

    const [open, setOpen] = useState(false);

    return <>
        <StyledTableRow key={row.eventCode}>
            <StyledTableCell>
                {row.selectedPlayers.length > 0 && <IconButton aria-label="delete" onClick={() => setOpen(!open)}>
                    {open ? <ExpandLessIcon/> : <ExpandMoreIcon/>}
                </IconButton>}
            </StyledTableCell>
            <StyledTableCell component="th" scope="row">{row.category}</StyledTableCell>
            <StyledTableCell align="right">{row.dateTime.replace("T", " ")}</StyledTableCell>
            <StyledTableCell align="right">{row.description}</StyledTableCell>
            <StyledTableCell align="right">{row.eventLocation}</StyledTableCell>
            <StyledTableCell align="right">{row.teamSize}</StyledTableCell>
            <StyledTableCell align="right">
                <IconButton edge="end" aria-label="delete"
                            onClick={() => handleDeleteRow(row)}>
                    <DeleteIcon/>
                </IconButton>
            </StyledTableCell>

        </StyledTableRow>
        <TableRow>
            <TableCell style={{paddingBottom: 0, paddingTop: 0}} colSpan={6}>
                <Collapse in={open} timeout="auto" unmountOnExit>
                    <Box margin={1}>
                        <Typography variant="h6" gutterBottom component="div">
                            Zawodnicy
                        </Typography>
                        <Table size="small" aria-label="purchases">
                            <TableHead>
                                <TableRow>
                                    <TableCell>Imie</TableCell>
                                    <TableCell>Pozycja</TableCell>
                                    <TableCell align="right">Email</TableCell>
                                    <TableCell align="right">Status</TableCell>
                                    <TableCell align="right">Obecność</TableCell>
                                </TableRow>
                            </TableHead>
                            <TableBody>
                                {row.selectedPlayers.map((player) => (
                                    <TableRow key={player.email}>
                                        <TableCell component="th" scope="row">
                                            {`${player.name} ${player.lastName}`}
                                        </TableCell>
                                        <TableCell>{player.position}</TableCell>
                                        <TableCell align="right">{player.email}</TableCell>
                                        <TableCell align="right">
                                            {translatePlayerStatus(player.playerStatus)}
                                        </TableCell>
                                        <TableCell align="right">
                                            {player.confirmedAttendance ? <CheckIcon/> : <ClearIcon/>}
                                        </TableCell>
                                    </TableRow>
                                ))}
                            </TableBody>
                        </Table>
                    </Box>
                </Collapse>
            </TableCell>
        </TableRow>
    </>
}