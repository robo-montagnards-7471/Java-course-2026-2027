import java.util.Scanner;

public class RobotGame {

    double positionX = 10;
    double positionY = 10;
    double directionX = 0;
    double directionY = -1;

    double vitesse = 0;

    char avatar = 'X'; // ^, v, <, >, X
    
    public static void main(String[] args) {
    
        RobotGame robot = new RobotGame();
        Scanner sc = new Scanner(System.in);

        while( true ) {   // boucle infinie
        
            System.out.print("Mouvement (w, a, s, d, q, r): ");
            String input = sc.nextLine() + 'x';
            char mouv = input.charAt(0);

            
            if( mouv == 'q' ) {
                break;
            }
            else if( mouv == 'r' ) {
                robot.reset();
            }
            else if( mouv == 'w' ) {
                robot.avancer();
            }
            else if( mouv == 'a' ) {
                robot.tournerGauche();
            }
            else if( mouv == 's' ) {
                robot.reculer();
            }
            else if( mouv == 'd' ) {
                robot.tournerDroite();
            }
            robot.deplacer();

            for( int i = 0; i < 50; i++ ) {
                System.out.println();
            }

            for( int y = 0; y < 20; y++ ) {
                for( int x = 0; x < 20; x++ ) {
                    if( robot.positionX == x && robot.positionY == y ) {
                        System.out.print(robot.avatar + " ");
                    }
                    else {
                        System.out.print("- ");
                    }
                }
                System.out.println();
            }
            System.out.println("Position: (" + robot.positionX + ", " + robot.positionY + ")");
            System.out.println("Direction: (" + robot.directionX + ", " + robot.directionY + ")");
            System.out.println("Vitesse: " + robot.vitesse);
        }

        System.out.print("Au revoir !");
    }
    
    public void avancer()  // w
    {
        vitesse += 1;
        if( vitesse > 1 ) {
            vitesse = 1;
        }

        if(  directionX == 1 && directionY == 0 ) {
            avatar = '>';
        }
        else if( directionX == -1 && directionY == 0 ) {
            avatar = '<';
        }
        else if( directionX == 0 && directionY == 1 ) {
            avatar = 'v';
        }
        else if( directionX == 0 && directionY == -1 ) {
            avatar = '^';
        }
        else {
            avatar = 'X';
        }
    }
    
    public void tournerGauche()  // a
    {
        double new_direction_x = directionY;
        double new_direction_y = directionX *-1;

        directionX = new_direction_x;
        directionY = new_direction_y;

        if(  directionX == 1 && directionY == 0 ) {
            avatar = '>';
        }
        else if( directionX == -1 && directionY == 0 ) {
            avatar = '<';
        }
        else if( directionX == 0 && directionY == 1 ) {
            avatar = 'v';
        }
        else if( directionX == 0 && directionY == -1 ) {
            avatar = '^';
        }
        else {
            avatar = 'X';
        }
    }
    
    public void reculer()  // s
    {
        vitesse -= 1;
        if( vitesse < -1 ) {
            vitesse = -1;
        }

        if(  directionX == 1 && directionY == 0 ) {
            avatar = '>';
        }
        else if( directionX == -1 && directionY == 0 ) {
            avatar = '<';
        }
        else if( directionX == 0 && directionY == 1 ) {
            avatar = 'v';
        }
        else if( directionX == 0 && directionY == -1 ) {
            avatar = '^';
        }
        else {
            avatar = 'X';
        }
    }
    
    public void tournerDroite()  // d
    {
        double new_direction_x = directionY *-1;
        double new_direction_y = directionX;

        directionX = new_direction_x;
        directionY = new_direction_y;

        if(  directionX == 1 && directionY == 0 ) {
            avatar = '>';
        }
        else if( directionX == -1 && directionY == 0 ) {
            avatar = '<';
        }
        else if( directionX == 0 && directionY == 1 ) {
            avatar = 'v';
        }
        else if( directionX == 0 && directionY == -1 ) {
            avatar = '^';
        }
        else {
            avatar = 'X';
        }
    }

    public void deplacer() {
        positionX += directionX * vitesse;
        positionY += directionY * vitesse;

        if( positionX < 0 ) {
            positionX = 0;
            vitesse = 0;
        }
        else if( positionX > 19 ) {
            positionX = 19;
            vitesse = 0;
        }

        if( positionY < 0 ) {
            positionY = 0;
            vitesse = 0;
        }
        else if( positionY > 19 ) {
            positionY = 19;
            vitesse = 0;
        }
    }

    public void reset() {
        positionX = 10;
        positionY = 10;
        directionX = 0;
        directionY = -1;
        vitesse = 0;
        avatar = 'X';
    }
}
