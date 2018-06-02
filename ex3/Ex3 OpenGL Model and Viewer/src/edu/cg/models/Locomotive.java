package edu.cg.models;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.glu.GLUquadric;

public class Locomotive implements IRenderable {
    private boolean isLightSpheres;

    public void render(GL2 gl) {
        drawLocomotive(gl);
    }


    @Override
    public String toString() {
        return "Empty";
    }


    //If your scene requires more control (like keyboard events), you can define it here.
    @Override
    public void control(int type, Object params) {
        switch (type) {
            case IRenderable.TOGGLE_LIGHT_SPHERES:
            {
                isLightSpheres = ! isLightSpheres;
                break;
            }
            default:
                System.out.println("Control type not supported: " + toString() + ", " + type);
        }
    }

    @Override
    public boolean isAnimated() {
        return false;
    }

    @Override
    public void init(GL2 gl) { }

    @Override
    public void setCamera(GL2 gl) { }

    /**
     * Chassis – The body of the locomotive. Filled polygons.
     ▪ Door – Filled polygon.
     ▪ Windows – Filled polygons
     */
    private void drawChassis(GL2 gl) {
        drawDoor(gl);
        drawWindows(gl);

    }

    private void drawDoor(GL2 gl) {

    }

    private void drawWindows(GL2 gl) {

    }

    /**
     * Wheels
     ▪ Wheel – Cylinder bounded by disks.
     */
    private void drawWeels(GL2 gl, GLU glu, GLUquadric q) {
        gl.glPushMatrix();
        gl.glColor3f(.2f,.15f,.1f); //brownish color
        // move to where first back wheel is
        gl.glTranslated(.2, -.2, .2);
        glu.gluCylinder(q, .1, .1, .1, 10, 1);
        // closing disk
        gl.glTranslated(0, 0, .1);
        glu.gluDisk(q, 0, .1, 10, 1);
        // different colored disk
        gl.glTranslated(0, 0, .001);
        gl.glColor3f(.3f,.1f,.1f); //brownish color
        glu.gluDisk(q, 0, .05, 10, 1);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glColor3f(.2f,.15f,.1f); //brownish color
        // move to where second back wheel is
        gl.glTranslated(.2, -.2, -.2);
        gl.glRotated(180, 1, 0, 0);
        glu.gluCylinder(q, .1, .1, .1, 10, 1);
        // closing disk
        gl.glTranslated(0, 0, .1);
        glu.gluDisk(q, 0, .1, 10, 1);
        // different colored disk
        gl.glTranslated(0, 0, .001);
        gl.glColor3f(.3f,.1f,.1f); //brownish color
        glu.gluDisk(q, 0, .05, 10, 1);
        gl.glPopMatrix();


        gl.glPushMatrix();
        gl.glColor3f(.2f,.15f,.1f); //brownish color
        // move to where first front wheel is
        gl.glTranslated(-.6, -.2, .2);
        glu.gluCylinder(q, .1, .1, .1, 10, 1);
        // closing disk
        gl.glTranslated(0, 0, .1);
        glu.gluDisk(q, 0, .1, 10, 1);
        // different colored disk
        gl.glTranslated(0, 0, .001);
        gl.glColor3f(.3f,.1f,.1f); //brownish color
        glu.gluDisk(q, 0, .05, 10, 1);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glColor3f(.2f,.15f,.1f); //brownish color
        // move to where second front wheel is
        gl.glTranslated(-.6, -.2, -.2);
        gl.glRotated(180, 1, 0, 0);
        glu.gluCylinder(q, .1, .1, .1, 10, 1);
        // closing disk
        gl.glTranslated(0, 0, .1);
        glu.gluDisk(q, 0, .1, 10, 1);
        // different colored disk
        gl.glTranslated(0, 0, .001);
        gl.glColor3f(.3f,.1f,.1f); //brownish color
        glu.gluDisk(q, 0, .05, 10, 1);
        gl.glPopMatrix();
    }

    /**
     * Lights
     ▪ Front light – Cylinder bounded by disk.
     */
    private void drawLights(GL2 gl, GLU glu, GLUquadric q) {
        gl.glPushMatrix();

        // first light
        gl.glColor3f( 0f,0f,0f ); // black

        // move to where first light is
        gl.glTranslated(-.8, -.1, -.1);
        gl.glRotated(90, 0, 1, 0);
        // draw dark cylinder
        glu.gluCylinder(q, 0.05, 0.05, .05, 10, 1);

        // draw light disk closing the cylinder
        gl.glRotated(180, 1, 0, 0);
        gl.glColor3f( 1f,1f,.9f ); // bright color
        glu.gluDisk(q, 0, .05, 10, 1);
        gl.glRotated(-180, 1, 0, 0);

        gl.glPopMatrix();
        gl.glPushMatrix();

        // second light
        gl.glColor3f( 0f,0f,0f ); // black

        // move to where second light is
        gl.glTranslated(-.8, -.1, .1);
        gl.glRotated(90, 0, 1, 0);
        // draw dark cylinder
        glu.gluCylinder(q, 0.05, 0.05, .05, 10, 1);

        // draw light disk closing the cylinder
        gl.glRotated(180, 1, 0, 0);
        gl.glColor3f( 1f,1f,.9f ); // bright color
        glu.gluDisk(q, 0, .05, 10, 1);
        gl.glRotated(-180, 1, 0, 0);

        gl.glPopMatrix();
    }

    /**
     * Roof – Non-uniformly scaled cylinder bounded by disks.
     */
    private void drawRoof(GL2 gl,  GLU glu, GLUquadric q) {
        gl.glPushMatrix();
        gl.glColor3f(0,0,0); //black color

        // move to where roof starts
        gl.glRotated(90, 0, 1, 0);
        gl.glTranslated(0, .2, -.3);
        gl.glScaled(1, .25, 1);

        // closing disk
        gl.glRotated(180, 1, 0, 0);
        glu.gluDisk(q, 0, .2, 10, 1);
        gl.glRotated(-180, 1, 0, 0);

        // roof cylinder
        glu.gluCylinder(q, .2, .2, .8, 10, 1);

        // move to end of roof
        gl.glTranslated(0, 0, .8);

        // closing disk
        glu.gluDisk(q, 0, .2, 10, 1);
        gl.glPopMatrix();
    }

    /**
     * Chimney – Two cylinders place on top of each other bounded by disks.
     */
    private void drawChimney(GL2 gl, GLU glu, GLUquadric q) {
        gl.glPushMatrix();

        gl.glColor3f(1f,0f,0f); //red color
        // move to where chimney starts
        gl.glTranslated(-.55, 0, 0);
        gl.glRotated(-90, 1, 0, 0);

        // low cylinder
        glu.gluCylinder(q, 0.075, 0.075, .2, 10, 1);

        gl.glTranslated(0, 0, .2);
        gl.glRotated(180, 1, 0, 0);
        glu.gluDisk(q, 0, .1, 10, 1);
        gl.glRotated(-180, 1, 0, 0);

        // high cylinder
        glu.gluCylinder(q, .1, .1, .1, 10, 1);

        gl.glTranslated(0, 0, .1);

        // closing disk
        glu.gluDisk(q, 0, .1, 10, 1);
        gl.glPopMatrix();
    }

    private void drawLocomotive(GL2 gl) {
        GLU glu = new GLU();
        GLUquadric q = glu.gluNewQuadric();


        drawChassis(gl);
        drawWeels(gl, glu, q);
        drawLights(gl, glu, q);
        drawRoof(gl, glu, q);
        drawChimney(gl, glu, q);

        glu.gluDeleteQuadric(q);
    }
}
