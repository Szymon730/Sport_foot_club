import React from 'react';
import Button from '@material-ui/core/Button';
import TextField from '@material-ui/core/TextField';
import Dialog from '@material-ui/core/Dialog';
import DialogActions from '@material-ui/core/DialogActions';
import DialogContent from '@material-ui/core/DialogContent';
import DialogTitle from '@material-ui/core/DialogTitle';


export default function AddEditPlayerDialog(props) {
    return (
        <div>
            <Dialog open={props.openAddPlayerDialog} onClose={props.handleCloseAddPlayerDialog}
                    aria-labelledby="form-dialog-title">
                <DialogTitle id="form-dialog-title">{props.addFlow ? "Dodaj nowego zawodnika" : "Edytuj informacje o zawodniku"}</DialogTitle>
                <DialogContent>
                    <TextField
                        autoFocus
                        margin="dense"
                        id="name"
                        label="Imię"
                        type="text"
                        fullWidth
                        value={props.name}
                        onChange={(event) => {
                            props.setName(event.target.value)
                        }}
                    />
                    <TextField
                        autoFocus
                        margin="dense"
                        id="lastName"
                        label="Nazwisko"
                        type="text"
                        fullWidth
                        value={props.lastName}
                        onChange={(event) => {
                            props.setLastName(event.target.value)
                        }}

                    />
                    <TextField
                        autoFocus
                        margin="dense"
                        id="birthDate"
                        label="data urodzenia"
                        type="text"
                        fullWidth
                        value={props.birthDate}
                        onChange={(event) => {
                            props.setBirthDate(event.target.value)
                        }}

                    />
                    <TextField
                        autoFocus
                        margin="dense"
                        id="position"
                        label="Pozycja na boisku"
                        type="text"
                        fullWidth
                        value={props.position}
                        onChange={(event) => {
                            props.setPosition(event.target.value)
                        }}
                    />
                    <TextField
                        autoFocus
                        margin="dense"
                        id="email"
                        label="Email Address"
                        type="email"
                        fullWidth
                        value={props.email}
                        onChange={(event) => {
                            props.setEmail(event.target.value)
                        }}
                    />
                </DialogContent>
                <DialogActions>
                    <Button onClick={props.handleCloseAddPlayerDialog} color="primary">
                        Anuluj
                    </Button>
                    <Button onClick={props.savePlayer} color="primary">
                        Zapisz
                    </Button>
                </DialogActions>
            </Dialog>
        </div>
    );
}