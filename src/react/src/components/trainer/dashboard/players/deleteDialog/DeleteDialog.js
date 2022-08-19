import React from 'react';
import Button from '@material-ui/core/Button';
import Dialog from '@material-ui/core/Dialog';
import DialogActions from '@material-ui/core/DialogActions';
import DialogTitle from '@material-ui/core/DialogTitle';

export default function DeleteDialog(props) {
    return (
        <div>
            <Dialog
                open={props.openDeleteDialog}
                onClose={() => props.setOpenDeleteDialog(false)}
                aria-labelledby="alert-dialog-title"
                aria-describedby="alert-dialog-description"
            >
                <DialogTitle id="alert-dialog-title">{"Usunąć zawodnika?"}</DialogTitle>
                <DialogActions>
                    <Button onClick={() => props.setOpenDeleteDialog(false)} color="primary">
                        Anuluj
                    </Button>
                    <Button onClick={props.deletePlayerConfirmed} color="primary" autoFocus>
                        Zatwierdź
                    </Button>
                </DialogActions>
            </Dialog>
        </div>
    );
}