async function onLanding() {
	setMainLed({ r: 0, g: 255, b: 0 });
	speak(buildString("land", false);
	await delay(0.5);
}
registerEvent(EventType.onLanding, onLanding);

async function startProgram() {
	while (true) {
		setMainLed({ r: 255, g: 255, b: 255 });
		await delay(0.1);
	}
}
