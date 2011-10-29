/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.component.characters;

import game.component.Component;

/**
 *
 * @author Lucas
 */
public class CharacterInfo extends Component {

    private final float gravity = 0.5f; //???????????????
    private final float jumpSpeed = 12f;
    private float vertSpeed;
    private boolean isJumping = false;
    private boolean isWalkingR = false;
    private boolean isWalkingL = false;
    float direction;
    float speed;

    public CharacterInfo(String id) {
        this.id = id;
        vertSpeed = 0;
        isJumping = false;
    }

    public float getDirection() {
        return direction;
    }

    public float getSpeed() {
        return speed;
    }

    public float getVertSpeed() {
        return vertSpeed;
    }

    public boolean isJumping() {
        return isJumping;
    }

    public boolean isWalkingR() {
        return isWalkingR;
    }

    public boolean isWalkingL() {
        return isWalkingL;
    }

    @Override
    public void control(/*Timer timer ?*/) {
        System.out.println(owner.getPosition().x + owner.getPosition().y);
////        float rotation = owner.getRotation();
////        float scale = owner.getScale();
//        Point pos = owner.getPosition();
////        Input input = gc.getInput();
//
//        if (input.isKeyDown(Input.KEY_LEFT) && pos.x > 0) {
//            pos.x -= 0.2f;
//            isWalkingL = true;
//        } else if (input.isKeyDown(Input.KEY_RIGHT) && pos.x < 800) {
//            pos.x += 0.2f;
//            isWalkingR = true;
//        } else {
//            isWalkingL = false;
//            isWalkingR = false;
//        }
//        if (isJumping) {
//            pos.y -= vertSpeed;
//            if (vertSpeed <= -jumpSpeed) {
//                vertSpeed = 0;
//                isJumping = false;
//            }
//            vertSpeed -= gravity;
//        } else {
//            if (input.isKeyDown(Input.KEY_SPACE)) {
//                vertSpeed = jumpSpeed;
//                isJumping = true;
//            }
//        }
//
//        owner.setPosition(pos);
////        owner.setRotation(rotation);
////        owner.setScale(scale);
    }
}
