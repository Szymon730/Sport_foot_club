const PLAYER_STATUS = {
    MAIN_TEAM: "główny skład",
    MAIN_TEAM_BENCH: "ławka rezerwowych",
    RESERVES: "rezerwy",
    INJURED: "kontuzjowany",
    BLOCKED: "zawieszony"
}

const translatePlayerStatus = (playerStatus) => {
    if (playerStatus)
        return PLAYER_STATUS[playerStatus];
    else return ""
}

export default translatePlayerStatus;