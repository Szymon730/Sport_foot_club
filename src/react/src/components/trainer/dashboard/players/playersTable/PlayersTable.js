import React, {useState} from 'react';
import PropTypes from 'prop-types';
import {makeStyles} from '@material-ui/core/styles';
import IconButton from '@material-ui/core/IconButton';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableContainer from '@material-ui/core/TableContainer';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Fab from '@material-ui/core/Fab';
import AddIcon from '@material-ui/icons/Add';
import DeleteIcon from '@material-ui/icons/Delete';
import EditIcon from '@material-ui/icons/Edit';
import Button from "@material-ui/core/Button";
import Popover from "@material-ui/core/Popover";
import FormControl from "@material-ui/core/FormControl";
import InputLabel from "@material-ui/core/InputLabel";
import Select from "@material-ui/core/Select";
import MenuItem from "@material-ui/core/MenuItem";
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
    if(row.playerStatus === "MAIN_TEAM" || row.playerStatus === "MAIN_TEAM_BENCH"){
        statusButtonColor = "primary";
    }else {
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
                            onClick={(event)=> {
                                props.setOpenPopover(true);
                                props.setAnchorEl(event.currentTarget);
                                props.setPlayerEmail(row.email);
                            }}
                    >
                        {PLAYER_STATUS[row.playerStatus]}
                    </Button>
                </TableCell>
                <IconButton edge="end" aria-label="delete" onClick={()=>props.deletePlayer(row.email)}>
                    <DeleteIcon/>
                </IconButton>
                <IconButton edge="end" aria-label="edit" onClick={()=>props.handleClickOpenEditPlayerDialog(props.row)}>
                    <EditIcon/>
                </IconButton>
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

    const [openPopover, setOpenPopover] = useState(false);
    const [anchorEl, setAnchorEl] = React.useState(null);


    const [playerEmail, setPlayerEmail] = React.useState('');
    const [playerStatus, setPlayerStatus] = React.useState('');

    const changePlayerStatus = (event) => {
        console.log(event.target.value)
        setPlayerStatus(event.target.value);

        const requestObject = {
            email: playerEmail,
            playerStatus: event.target.value
        }
        console.log(requestObject);
        axios.put("/player/changeStatus", requestObject)
            .then(response => {
                const data = response.data;
                console.log(data);
                props.fetchPlayers();
                setOpenPopover(false);
            });

    }

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
                        <TableCell align="right">Status zawodnika</TableCell>

                        <TableCell align="right">
                            <Fab color="primary" aria-label="add"
                                 onClick={() => props.handleClickOpenAddPlayerDialog()}>
                                <AddIcon/>
                            </Fab>
                        </TableCell>
                    </TableRow>
                </TableHead>
                <TableBody>
                    {props.players.map((player) => (
                        <Row key={player.name}
                             row={player}
                             handleClickOpenEditPlayerDialog={props.handleClickOpenEditPlayerDialog}
                             deletePlayer={props.deletePlayer}
                             openPopover={openPopover}
                             setOpenPopover={setOpenPopover}
                             anchorEl={anchorEl}
                             setAnchorEl={setAnchorEl}
                             setPlayerEmail={setPlayerEmail}
                        />
                    ))}
                </TableBody>
            </Table>
            <Popover
                open={openPopover}
                onBackdropClick={()=>setOpenPopover(false)}
                anchorEl={anchorEl}
                anchorOrigin={{
                    vertical: 'center',
                    horizontal: 'right',
                }}
                transformOrigin={{
                    vertical: 'center',
                    horizontal: 'left',
                }}>
                <FormControl variant="outlined"
                             className={classes.formControl}
                >
                    <InputLabel id="demo-simple-select-outlined-label">Status</InputLabel>
                    <Select
                        labelId="demo-simple-select-outlined-label"
                        id="demo-simple-select-outlined"
                        value={playerStatus}
                        onChange={changePlayerStatus}
                        label="Status"
                    >
                        <MenuItem value="">
                            <em>None</em>
                        </MenuItem>
                        <MenuItem value={"MAIN_TEAM"}>{PLAYER_STATUS["MAIN_TEAM"]}</MenuItem>
                        <MenuItem value={"MAIN_TEAM_BENCH"}>{PLAYER_STATUS["MAIN_TEAM_BENCH"]}</MenuItem>
                        <MenuItem value={"RESERVES"}>{PLAYER_STATUS["RESERVES"]}</MenuItem>
                        <MenuItem value={"INJURED"}>{PLAYER_STATUS["INJURED"]}</MenuItem>
                        <MenuItem value={"BLOCKED"}>{PLAYER_STATUS["BLOCKED"]}</MenuItem>

                    </Select>
                </FormControl>
            </Popover>
        </TableContainer>
    );
}