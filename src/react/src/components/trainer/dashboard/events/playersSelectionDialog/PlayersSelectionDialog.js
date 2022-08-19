import React from 'react';
import Button from '@material-ui/core/Button';
import Dialog from '@material-ui/core/Dialog';
import DialogActions from '@material-ui/core/DialogActions';
import DialogContent from '@material-ui/core/DialogContent';
import DialogTitle from '@material-ui/core/DialogTitle';
import axios from "axios";
import PlayerSelectionList from "./playersSelectionList/PlayerSelectionList";
import {Typography} from "@material-ui/core";


const createNewEventPlace = (newEventPlace, completeAction) => {
    axios.post("/createNewEventPlace", newEventPlace)
        .then(data => {
            completeAction();
        })
}

export default function PlayersSelectionDialog(props) {
    const [open, setOpen] = React.useState(false);

    const handleClickOpen = () => {
        setOpen(true);
    };

    const handleClose = () => {
        setOpen(false);
    };

    const createNewEventPlaceAndCloseDialog = () => {
        handleClose();
    };

    return (
        <div>
            <Button onClick={handleClickOpen}>Dodaj zawodników</Button>
            <Dialog open={open} onClose={handleClose} aria-labelledby="form-dialog-title">
                <DialogTitle id="form-dialog-title">Lista zawodników</DialogTitle>
                <DialogContent>
                    {parseInt(props.teamSize) > props.selectedPlayers.length && <Typography variant="h4" component="h5" color={"secondary"}>
                        Wybierz więcej zawodników! ({parseInt(props.teamSize) - props.selectedPlayers.length})
                    </Typography>}
                    <PlayerSelectionList availablePlayers={props.availablePlayers}
                                         setAvailablePlayers={props.setAvailablePlayers}
                                         selectedPlayers={props.selectedPlayers}
                                         setSelectedPlayers={props.setSelectedPlayers}/>
                </DialogContent>
                <DialogActions>
                    <Button onClick={createNewEventPlaceAndCloseDialog} color="primary">
                        Zapisz
                    </Button>
                </DialogActions>
            </Dialog>
        </div>
    );
}