import React from 'react';
import Grid from '@material-ui/core/Grid';
import Typography from '@material-ui/core/Typography';
import TextField from '@material-ui/core/TextField';

export default function TrainerDetails(props) {

    return (
        <React.Fragment>
            <Typography variant="h6" gutterBottom>
                Dane osobowe
            </Typography>
            <Grid container spacing={3}>
                <Grid item xs={12} sm={6}>
                    <TextField
                        required
                        id="firstName"
                        name="firstName"
                        label="Imię"
                        fullWidth
                        autoComplete="given-name"
                        value={props.name}
                        onChange={(event)=>props.setName(event.target.value)}
                    />
                </Grid>
                <Grid item xs={12} sm={6}>
                    <TextField
                        required
                        id="lastName"
                        name="lastName"
                        label="Nazwisko"
                        fullWidth
                        autoComplete="family-name"
                        value={props.lastName}
                        onChange={(event)=>props.setLastName(event.target.value)}
                    />
                </Grid>
                <Grid item xs={12}>
                    <TextField
                        required
                        id="address1"
                        name="address1"
                        label="Adres zamieszkania"
                        fullWidth
                        autoComplete="shipping address-line1"
                        value={props.address}
                        onChange={(event)=>props.setAddress(event.target.value)}
                    />
                </Grid>
                <Grid item xs={12} sm={6}>
                    <TextField
                        required
                        id="city"
                        name="city"
                        label="Miasto"
                        fullWidth
                        value={props.city}
                        onChange={(event)=>props.setCity(event.target.value)}
                    />
                </Grid>
                <Grid item xs={12} sm={6}>
                    <TextField id="state"
                               name="state"
                               label="Województwo"
                               fullWidth
                               onChange={(event) => props.setProvince(event.target.value)}
                               value={props.province}/>
                </Grid>
                <Grid item xs={12} sm={6}>
                    <TextField
                        required
                        id="zip"
                        name="zip"
                        label="Kod pocztowy"
                        fullWidth
                        autoComplete="shipping postal-code"
                        value={props.zipCode}
                        onChange={(event)=> {
                            props.setZipCode(event.target.value)
                        }}
                    />
                </Grid>
            </Grid>
        </React.Fragment>
    );
}