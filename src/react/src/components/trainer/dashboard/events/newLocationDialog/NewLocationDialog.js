import React, {useState} from 'react';
import Button from '@material-ui/core/Button';
import TextField from '@material-ui/core/TextField';
import Dialog from '@material-ui/core/Dialog';
import DialogActions from '@material-ui/core/DialogActions';
import DialogContent from '@material-ui/core/DialogContent';
import DialogTitle from '@material-ui/core/DialogTitle';
import axios from "axios";


const createNewEventPlace = (newEventPlace, completeAction) => {
    axios.post("/createNewEventPlace", newEventPlace)
        .then(data => {
            completeAction();
        })
}

export default function NewLocationDialog(props) {
    const [open, setOpen] = React.useState(false);

    const [name, setName] = useState("");
    const [address, setaddress] = useState("");
    const [email, setEmail] = useState("");
    const [phone, setPhone] = useState("");
    const [description, setDescription] = useState("");


    const handleChangeText = (event, fieldName = "description") => {
        const form = {
            name: setName,
            address: setaddress,
            email: setEmail,
            phone: setPhone,
            description: setDescription
        }
        form[event.target.name](event.target.value);
    }

    const handleClickOpen = () => {
        setOpen(true);
    };

    const handleClose = () => {
        setOpen(false);
    };

    const createNewEventPlaceAndCloseDialog = () => {

        const request = {
            name, address, email, phone, description,
        }
        createNewEventPlace(request, () => {
            props.fetchLocations();
            setOpen(false)
        });

    };

    return (
        <div>
            <Button onClick={handleClickOpen}>Dodaj nowe miejsce</Button>
            <Dialog open={open} onClose={handleClose} aria-labelledby="form-dialog-title">
                <DialogTitle id="form-dialog-title">Dodaj nowe miejsce wydarzenia</DialogTitle>
                <DialogContent>
                    <TextField
                        autoFocus
                        margin="dense"
                        id="name"
                        label="Name"
                        type="text"
                        name={"name"}
                        onChange={event => handleChangeText(event)}
                        value={name}
                        fullWidth
                    />
                    <TextField
                        autoFocus
                        margin="dense"
                        id="address"
                        label="Adres"
                        type="text"
                        name={"address"}
                        onChange={event => handleChangeText(event)}
                        value={address}
                        fullWidth
                    />
                    <TextField
                        autoFocus
                        margin="dense"
                        id="email"
                        label="Email Address"
                        type="text"
                        name={"email"}
                        onChange={event => handleChangeText(event)}
                        value={email}
                        fullWidth
                    />
                    <TextField
                        autoFocus
                        margin="dense"
                        id="phone"
                        label="Numer telefonu"
                        type="phone"
                        value={phone}
                        name={"phone"}
                        onChange={event => handleChangeText(event)}
                        fullWidth
                    />
                    <TextField
                        autoFocus
                        margin="dense"
                        id="description"
                        label="Opis"
                        type="text"
                        value={description}
                        name={"description"}
                        onChange={event => handleChangeText(event)}
                        fullWidth
                    />
                </DialogContent>
                <DialogActions>
                    <Button onClick={handleClose} color="primary">
                        Anuluj
                    </Button>
                    <Button onClick={createNewEventPlaceAndCloseDialog} color="primary">
                        Zatwierdz
                    </Button>
                </DialogActions>
            </Dialog>
        </div>
    );
}