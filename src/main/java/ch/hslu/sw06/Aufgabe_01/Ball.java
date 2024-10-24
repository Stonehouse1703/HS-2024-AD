package ch.hslu.sw06.Aufgabe_01;

/**
 * Description of class Ball
 */
public class Ball implements Runnable {

    private final Circle circle;
    private final String[] colors = {"red", "black", "blue", "yellow", "green", "magenta"};
    boolean movingDown = true;

    public Ball() {
        // Zufällige Ballgröße und zufällige Startposition setzen
        int diameter = (int) (Math.random() * 50) + 30; // Größe zwischen 30 und 80
        int xPos = (int) (Math.random() * 550); // Zufällige x-Position
        int yPos = (int) (Math.random() * 330); // Start von oben

        // Einen Kreis erstellen
        this.circle = new Circle(diameter, xPos, yPos, colors[(int)(Math.random() * colors.length)]);

        if(Math.random() * 2 == 0){
            movingDown = true;
        } else {
            movingDown = false;
        }
    }

    @Override
    public void run() {
        // Ball sichtbar machen
        circle.makeVisible();



        while (circle.getSize() > 10) {
            if (movingDown) {
                // Ball nach unten bewegen, bis er den Boden erreicht
                while (circle.getY() < 330) {
                    circle.moveDown();
                    Canvas.getCanvas().wait(30); // Wartezeit für Animation
                }
                movingDown = false;
            } else {
                // Ball nach oben bewegen, bis er oben ankommt
                while (circle.getY() > 0) {
                    circle.moveUp();
                    Canvas.getCanvas().wait(30); // Wartezeit für Animation
                }
                movingDown = true;
            }

            // Die Größe des Balls verkleinern
            circle.changeSize(circle.getSize() - 10);

            // Farbe des Balls zufällig ändern
            circle.changeColor(colors[(int) (Math.random() * colors.length)]);
        }

        // Ball unsichtbar machen, wenn er klein genug ist
        circle.makeInvisible();
    }
}
