import React from 'react';
import ListItem from '@material-ui/core/ListItem';
import ListItemIcon from '@material-ui/core/ListItemIcon';
import ListItemText from '@material-ui/core/ListItemText';
import ListSubheader from '@material-ui/core/ListSubheader';
import DashboardIcon from '@material-ui/icons/Dashboard';
import AssignmentIcon from '@material-ui/icons/Assignment';
import MessageIcon from '@material-ui/icons/Message';
import EqualizerIcon from '@material-ui/icons/Equalizer';
import EventNoteIcon from '@material-ui/icons/EventNote';
import CalendarTodayIcon from '@material-ui/icons/CalendarToday';
import GroupIcon from '@material-ui/icons/Group';
import {TIMETABLE, DASHBOARD, EVENTS, MESSAGES, PLAYERS, STATS} from "./trainerPanePages";

const TrainerPaneNav = (props) =>  (
    <div>
        <ListItem button onClick={()=>props.setPage(DASHBOARD)}>
            <ListItemIcon>
                <DashboardIcon/>
            </ListItemIcon>
            <ListItemText primary="Dashboard"/>
        </ListItem>
        <ListItem button onClick={()=>props.setPage(PLAYERS)}>
            <ListItemIcon>
                <GroupIcon/>
            </ListItemIcon>
            <ListItemText primary="Zawodnicy"/>
        </ListItem>
        <ListItem button onClick={()=>props.setPage(TIMETABLE)}>
            <ListItemIcon>
                <CalendarTodayIcon/>
            </ListItemIcon>
            <ListItemText primary="Terminarz"/>
        </ListItem>
        <ListItem button onClick={()=>props.setPage(STATS)}>
            <ListItemIcon>
                <EqualizerIcon/>
            </ListItemIcon>
            <ListItemText primary="Statystyki zespołu"/>
        </ListItem>
        <ListItem button onClick={()=>props.setPage(EVENTS)}>
            <ListItemIcon>
                <EventNoteIcon/>
            </ListItemIcon>
            <ListItemText primary="Wydarzenia"/>
        </ListItem>
        <ListItem button onClick={()=>props.setPage(MESSAGES)}>
            <ListItemIcon>
                <MessageIcon/>
            </ListItemIcon>
            <ListItemText primary="Wiadomości"/>
        </ListItem>
    </div>
);

export default TrainerPaneNav;