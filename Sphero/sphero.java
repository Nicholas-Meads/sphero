async function startProgram() {
    await speak("Hello World", true);
    setMainLed({ r: 0, g: 0, b: 255});
    setSpeed(60.0);
    await delay (2.0);
    setSpeed(0.0);
}
