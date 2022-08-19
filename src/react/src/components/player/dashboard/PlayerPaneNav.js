import React from 'react';
import ListItem from '@material-ui/core/ListItem';
import ListItemIcon from '@material-ui/core/ListItemIcon';
import ListItemText from '@material-ui/core/ListItemText';
import CalendarTodayIcon from '@material-ui/icons/CalendarToday';
import GroupIcon from '@material-ui/icons/Group';
import {PLAYERS, TIMETABLE} from "./playerPanePages";

const PlayerPaneNav = (props) => (
    <div>
        <ListItem button onClick={() => props.setPage(PLAYERS)}>
            <ListItemIcon>
                <GroupIcon/>
            </ListItemIcon>
            <ListItemText primary="Zawodnicy"/>
        </ListItem>
        <ListItem button onClick={() => props.setPage(TIMETABLE)}>
            <ListItemIcon>
                <CalendarTodayIcon/>
            </ListItemIcon>
            <ListItemText primary="Terminarz"/>
        </ListItem>
    </div>
);

export default PlayerPaneNav;