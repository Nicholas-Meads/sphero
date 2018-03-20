var currentState = null;

async function stateReady() {
    setStabilization(false);
    setMainLed({r:255, g:0, b:0});
    await speak("Ready!");
    await delay(1.0);
    currentState = stateSet;
};

async function stateSet() {
    setMainLed({r:255, g:255, b:0});
    await speak("Set!");
    await delay(1.0);
    currentState = stateGo;
};

async function stateGo() {
    setStabilization(true);
    resetAim();
    setMainLed({r:0, g:255, b:0});
    await speak("Go!");
    await roll(0, 100);
    await delay(1.0);
    setMainLed({r:0, g: 0, b:0});
    await delay(2.0);
    currentState = statePause;
};

async function statePause() {
    stopRoll(180);
    await delay(1.0);
    currentState = stateReturn;
};

async function stateReturn() {
    await roll(180, 100);
    await delay(3.0);
    stopRoll(180);
    exitProgram();
};

async function startProgram() {
    currentState = stateReady;

    while(true) {
        await currentState();
    }
};
