// 
// Decompiled by Procyon v0.5.30
// 

package edu.cg.models;

import com.jogamp.opengl.glu.GLUquadric;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.GL2;
import edu.cg.algebra.Vec;

public class Locomotive1 implements IRenderable
{
    private boolean isLightSpheres;
    private static final double EPS = 0.002;
    private static final Vec black;
    private static final Vec white;
    
    static {
        black = new Vec();
        white = new Vec(1.0f);
    }
    
    public Locomotive1() {
        this.isLightSpheres = true;
    }
    
    @Override
    public void render(final GL2 gl) {
        gl.glTranslated(0.2, 0.0, 0.0);
        gl.glLineWidth(4.0f);
        gl.glMaterialf(1028, 5633, 10.0f);
        final float[] light0Pos = { 0.6f, 0.4f, -0.6f, 1.0f };
        final float[] light0Color = { 1.0f, 1.0f, 0.5f, 1.0f };
        gl.glLightfv(16384, 4608, Locomotive1.white.toGLColor());
        gl.glLightfv(16384, 4609, light0Color, 0);
        gl.glLightfv(16384, 4610, light0Color, 0);
        gl.glLightfv(16384, 4611, light0Pos, 0);
        gl.glEnable(16384);
        final float[] light1Pos = { -1.0f, 0.3f, 0.6f, 1.0f };
        final float[] light1Color = { 1.0f, 1.0f, 1.0f, 1.0f };
        gl.glLightfv(16385, 4609, light1Color, 0);
        gl.glLightfv(16385, 4610, light1Color, 0);
        gl.glLightfv(16385, 4611, light1Pos, 0);
        gl.glEnable(16385);
        final GLU glu = new GLU();
        final GLUquadric quad = glu.gluNewQuadric();
        if (this.isLightSpheres) {
            final boolean lightFlag = gl.glIsEnabled(2896);
            gl.glDisable(2896);
            gl.glPushMatrix();
            gl.glTranslated(light0Pos[0], light0Pos[1], light0Pos[2]);
            gl.glColor4fv(light0Color, 0);
            glu.gluSphere(quad, 0.02, 6, 3);
            gl.glPopMatrix();
            gl.glPushMatrix();
            gl.glTranslated(light1Pos[0], light1Pos[1], light1Pos[2]);
            gl.glColor4fv(light1Color, 0);
            glu.gluSphere(quad, 0.02, 6, 3);
            gl.glPopMatrix();
            if (lightFlag) {
                gl.glEnable(2896);
            }
        }
        this.drawChassis(gl);
        this.drawWheels(gl, glu, quad);
        this.drawLights(gl, glu, quad);
        this.drawRoof(gl, glu, quad);
        this.drawChimney(gl, glu, quad);
        glu.gluDeleteQuadric(quad);
        gl.glDisable(16384);
        gl.glDisable(16385);
    }
    
    private void drawChimney(final GL2 gl, final GLU glu, final GLUquadric quad) {
        this.setMaterialChassis(gl);
        gl.glPushMatrix();
        gl.glTranslated(-0.55, 0.0, 0.0);
        gl.glRotated(-90.0, 1.0, 0.0, 0.0);
        glu.gluCylinder(quad, 0.075, 0.075, 0.2, 20, 1);
        gl.glTranslated(0.0, 0.0, 0.2);
        gl.glPushMatrix();
        gl.glRotated(180.0, 1.0, 0.0, 0.0);
        glu.gluDisk(quad, 0.0, 0.1, 20, 1);
        gl.glPopMatrix();
        glu.gluCylinder(quad, 0.1, 0.1, 0.1, 20, 1);
        gl.glTranslated(0.0, 0.0, 0.1);
        glu.gluDisk(quad, 0.0, 0.1, 20, 1);
        gl.glPopMatrix();
    }
    
    private void drawQuadZ(final GL2 gl, final double x1, final double x2, final double y1, final double y2, final double z) {
        gl.glBegin(7);
        gl.glVertex3d(x1, y1, -z);
        gl.glVertex3d(x1, y1, z);
        gl.glVertex3d(x2, y2, z);
        gl.glVertex3d(x2, y2, -z);
        gl.glEnd();
    }
    
    private void setMaterialRoof(final GL2 gl) {
        gl.glColor3fv(Locomotive1.black.toGLColor());
        gl.glMaterialfv(1028, 4608, Locomotive1.white.mult(0.1).toGLColor());
        gl.glMaterialfv(1028, 4609, Locomotive1.black.toGLColor());
        gl.glMaterialfv(1028, 4610, Locomotive1.white.mult(0.7).toGLColor());
        gl.glMaterialfv(1028, 5632, Locomotive1.black.toGLColor());
    }
    
    private void setMaterialChassis(final GL2 gl) {
        final Vec diffuseCol = new Vec(1.0f, 0.039215688f, 0.0f);
        gl.glColor3fv(Locomotive1.white.toGLColor());
        gl.glMaterialfv(1028, 4608, diffuseCol.mult(0.2).toGLColor());
        gl.glMaterialfv(1028, 4609, diffuseCol.toGLColor());
        gl.glMaterialfv(1028, 4610, Locomotive1.white.mult(0.7).toGLColor());
        gl.glMaterialfv(1028, 5632, Locomotive1.black.toGLColor());
    }
    
    private void setMaterialWindowOrDoor(final GL2 gl) {
        final Vec col = new Vec(0.1f, 0.1f, 0.2f);
        gl.glColor3fv(col.toGLColor());
        gl.glMaterialfv(1028, 4608, col.mult(0.2).toGLColor());
        gl.glMaterialfv(1028, 4609, col.toGLColor());
        gl.glMaterialfv(1028, 4610, col.mult(0.7).toGLColor());
        gl.glMaterialfv(1028, 5632, Locomotive1.black.toGLColor());
    }
    
    private void setMaterialWheelOuter(final GL2 gl) {
        final Vec col = new Vec(0.3137255f, 0.19607843f, 0.078431375f);
        gl.glColor3fv(col.toGLColor());
        gl.glMaterialfv(1028, 4608, col.mult(0.2).toGLColor());
        gl.glMaterialfv(1028, 4609, col.toGLColor());
        gl.glMaterialfv(1028, 4610, Locomotive1.black.toGLColor());
        gl.glMaterialfv(1028, 5632, Locomotive1.black.toGLColor());
    }
    
    private void setMaterialWheelInner(final GL2 gl) {
        final Vec col = new Vec(0.5f, 0.1f, 0.05f);
        gl.glColor3fv(col.toGLColor());
        gl.glMaterialfv(1028, 4608, col.mult(0.2).toGLColor());
        gl.glMaterialfv(1028, 4609, col.toGLColor());
        gl.glMaterialfv(1028, 4610, Locomotive1.black.toGLColor());
        gl.glMaterialfv(1028, 5632, Locomotive1.black.toGLColor());
    }
    
    private void setMaterialLightCase(final GL2 gl) {
        final Vec col = new Vec(0.2f, 0.2f, 0.2f);
        gl.glColor3fv(col.toGLColor());
        gl.glMaterialfv(1028, 4608, col.mult(0.2).toGLColor());
        gl.glMaterialfv(1028, 4609, col.toGLColor());
        gl.glMaterialfv(1028, 4610, Locomotive1.black.toGLColor());
        gl.glMaterialfv(1028, 5632, Locomotive1.black.toGLColor());
    }
    
    private void setMaterialFrontLight(final GL2 gl) {
        final float[] col = { 0.9f, 0.9f, 0.8f };
        gl.glColor3fv(col, 0);
        gl.glMaterialfv(1028, 4609, col, 0);
        gl.glMaterialfv(1028, 4610, Locomotive1.black.toGLColor());
        gl.glMaterialfv(1028, 5632, col, 0);
    }
    
    private void drawChassis(final GL2 gl) {
        this.setMaterialChassis(gl);
        gl.glNormal3f(0.0f, -1.0f, 0.0f);
        this.drawQuadZ(gl, 0.5, -0.8, -0.2, -0.2, 0.2);
        gl.glNormal3f(0.0f, 1.0f, 0.0f);
        this.drawQuadZ(gl, -0.8, -0.3, 0.0, 0.0, 0.2);
        this.drawQuadZ(gl, -0.3, 0.5, 0.2, 0.2, 0.2);
        gl.glNormal3f(-1.0f, 0.0f, 0.0f);
        this.drawQuadZ(gl, -0.3, -0.3, 0.0, 0.2, 0.2);
        this.drawQuadZ(gl, -0.8, -0.8, -0.2, 0.0, 0.2);
        gl.glNormal3f(1.0f, 0.0f, 0.0f);
        this.drawQuadZ(gl, 0.5, 0.5, 0.2, -0.2, 0.2);
        this.drawLeftSide(gl);
        this.drawRightSide(gl);
        this.drawFrontWindow(gl);
        this.drawBackWindow(gl);
    }
    
    private void drawRoof(final GL2 gl, final GLU glu, final GLUquadric quad) {
        final double l = 0.796;
        this.setMaterialRoof(gl);
        gl.glPushMatrix();
        gl.glTranslated(-0.298, 0.2, 0.0);
        gl.glScaled(1.0, 0.25, 1.0);
        gl.glRotated(90.0, 0.0, 1.0, 0.0);
        glu.gluCylinder(quad, 0.2, 0.2, 0.796, 20, 1);
        gl.glTranslated(0.0, 0.0, 0.796);
        glu.gluDisk(quad, 0.0, 0.2, 20, 1);
        gl.glTranslated(0.0, 0.0, -0.796);
        gl.glRotated(180.0, 1.0, 0.0, 0.0);
        glu.gluDisk(quad, 0.0, 0.2, 20, 1);
        gl.glPopMatrix();
    }
    
    private void drawWindowOrDoor(final GL2 gl) {
        this.setMaterialWindowOrDoor(gl);
        gl.glNormal3d(0.0, 0.0, 1.0);
        gl.glBegin(7);
        gl.glVertex3d(0.0, 0.0, 0.0);
        gl.glVertex3d(0.1, 0.0, 0.0);
        gl.glVertex3d(0.1, 0.1, 0.0);
        gl.glVertex3d(0.0, 0.1, 0.0);
        gl.glEnd();
    }
    
    private void drawLeftSide(final GL2 gl) {
        this.drawLeftSideWithoutFrontWindow(gl);
        gl.glPushMatrix();
        gl.glTranslated(-0.2, -0.05, 0.202);
        gl.glScaled(1.5, 2.0, 1.0);
        this.drawWindowOrDoor(gl);
        gl.glPopMatrix();
    }
    
    private void drawLeftSideWithoutFrontWindow(final GL2 gl) {
        this.setMaterialChassis(gl);
        gl.glNormal3d(0.0, 0.0, 1.0);
        gl.glBegin(7);
        gl.glVertex3d(-0.8, -0.2, 0.2);
        gl.glVertex3d(-0.3, -0.2, 0.2);
        gl.glVertex3d(-0.3, 0.0, 0.2);
        gl.glVertex3d(-0.8, 0.0, 0.2);
        gl.glVertex3d(-0.3, -0.2, 0.2);
        gl.glVertex3d(0.5, -0.2, 0.2);
        gl.glVertex3d(0.5, 0.2, 0.2);
        gl.glVertex3d(-0.3, 0.2, 0.2);
        gl.glEnd();
        gl.glPushMatrix();
        gl.glScaled(1.5, 2.0, 1.0);
        gl.glTranslated(-0.13333333333333333, -0.025, 0.202);
        gl.glTranslated(0.16666666666666666, 0.0, 0.0);
        this.drawWindowOrDoor(gl);
        gl.glTranslated(0.16666666666666666, 0.0, 0.0);
        this.drawWindowOrDoor(gl);
        gl.glPopMatrix();
    }
    
    private void drawFrontWindow(final GL2 gl) {
        gl.glPushMatrix();
        gl.glScaled(1.0, 1.5, 3.0);
        gl.glTranslated(-0.302, 0.0, -0.05);
        gl.glRotated(-90.0, 0.0, 1.0, 0.0);
        this.drawWindowOrDoor(gl);
        gl.glPopMatrix();
    }
    
    private void drawBackWindow(final GL2 gl) {
        gl.glPushMatrix();
        gl.glTranslated(0.0, -0.05, 0.0);
        gl.glScaled(1.0, 2.0, 3.0);
        gl.glTranslated(0.502, 0.0, 0.05);
        gl.glRotated(90.0, 0.0, 1.0, 0.0);
        this.drawWindowOrDoor(gl);
        gl.glPopMatrix();
    }
    
    private void drawRightSide(final GL2 gl) {
        gl.glFrontFace(2304);
        gl.glScaled(1.0, 1.0, -1.0);
        this.drawLeftSideWithoutFrontWindow(gl);
        gl.glPushMatrix();
        gl.glTranslated(-0.2, -0.2, 0.202);
        gl.glScaled(1.5, 3.5, 1.0);
        this.drawWindowOrDoor(gl);
        gl.glPopMatrix();
        gl.glScaled(1.0, 1.0, -1.0);
        gl.glFrontFace(2305);
    }
    
    private void drawWheels(final GL2 gl, final GLU glu, final GLUquadric quad) {
        gl.glPushMatrix();
        gl.glTranslated(-0.6, -0.2, 0.0);
        this.drawWheelPair(gl, glu, quad);
        gl.glTranslated(0.8, 0.0, 0.0);
        this.drawWheelPair(gl, glu, quad);
        gl.glPopMatrix();
    }
    
    private void drawWheelPair(final GL2 gl, final GLU glu, final GLUquadric quad) {
        gl.glPushMatrix();
        gl.glTranslated(0.0, 0.0, -0.2);
        this.drawWheel(gl, glu, quad);
        gl.glTranslated(0.0, 0.0, 0.4);
        this.drawWheel(gl, glu, quad);
        gl.glTranslated(0.0, 0.0, -0.2);
        gl.glPopMatrix();
    }
    
    private void drawWheel(final GL2 gl, final GLU glu, final GLUquadric quad) {
        this.setMaterialWheelOuter(gl);
        gl.glTranslated(0.0, 0.0, -0.05);
        glu.gluCylinder(quad, 0.125, 0.125, 0.1, 20, 1);
        gl.glRotated(180.0, 1.0, 0.0, 0.0);
        glu.gluDisk(quad, 0.08, 0.125, 20, 1);
        this.setMaterialWheelInner(gl);
        glu.gluDisk(quad, 0.0, 0.08, 20, 1);
        gl.glRotated(-180.0, 1.0, 0.0, 0.0);
        gl.glTranslated(0.0, 0.0, 0.1);
        this.setMaterialWheelOuter(gl);
        glu.gluDisk(quad, 0.08, 0.125, 20, 1);
        this.setMaterialWheelInner(gl);
        glu.gluDisk(quad, 0.0, 0.08, 20, 1);
        gl.glTranslated(0.0, 0.0, -0.05);
    }
    
    private void drawLights(final GL2 gl, final GLU glu, final GLUquadric quad) {
        this.drawFrontLights(gl, glu, quad);
    }
    
    private void drawFrontLights(final GL2 gl, final GLU glu, final GLUquadric quad) {
        gl.glPushMatrix();
        gl.glTranslated(-0.825, -0.1, 0.0);
        gl.glTranslated(0.0, 0.0, -0.1);
        this.drawFrontLight(gl, glu, quad);
        gl.glTranslated(0.0, 0.0, 0.2);
        this.drawFrontLight(gl, glu, quad);
        gl.glPopMatrix();
    }
    
    private void drawFrontLight(final GL2 gl, final GLU glu, final GLUquadric quad) {
        final double r = 0.05;
        gl.glRotated(90.0, 0.0, 1.0, 0.0);
        this.setMaterialLightCase(gl);
        glu.gluCylinder(quad, 0.05, 0.05, 0.05, 20, 1);
        this.setMaterialFrontLight(gl);
        gl.glRotated(180.0, 1.0, 0.0, 0.0);
        glu.gluDisk(quad, 0.0, 0.05, 20, 1);
        gl.glRotated(180.0, 1.0, 0.0, 0.0);
        gl.glRotated(-90.0, 0.0, 1.0, 0.0);
    }
    
    @Override
    public String toString() {
        return "Locomotive";
    }
    
    @Override
    public void control(final int type, final Object params) {
        switch (type) {
            case 0: {
                this.isLightSpheres = !this.isLightSpheres;
                break;
            }
            default: {
                System.out.println("Control type not supported: " + this.toString() + ", " + type);
                break;
            }
        }
    }
    
    @Override
    public boolean isAnimated() {
        return false;
    }
    
    @Override
    public void init(final GL2 gl) {
    }
    
    @Override
    public void setCamera(final GL2 gl) {
    }
}
