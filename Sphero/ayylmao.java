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
    stopRoll(90);
};

async function onCollision() {
	stopRoll();
	setMainLed({ r: 255, g: 0, b: 0 });
	await speak(buildString("Collision"), false);
	setHeading((getHeading() + 180));
	await delay(0.5);
	setMainLed({ r: 255, g: 22, b: 255 });
	setSpeed(100);
}

registerEvent(EventType.onCollision, onCollision);
async function startProgram() {
  if (EventType.onCollision = false) {
    setMainLed({
      r: 255,
      g: 0,
      b: 0
    });
    setHeading(getHeading() + 180);
    setSpeed(200);
  } else {
    setMainLed({
  		r: 255,
  		g: 255,
  		b: 255
  	});
    setHeading(getHeading() + 90);
  	setSpeed(200);
  }
}
