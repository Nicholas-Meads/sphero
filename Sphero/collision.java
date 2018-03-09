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
	setMainLed({
		r: 255,
		g: 255,
		b: 255
	});
	setSpeed(100);
}
