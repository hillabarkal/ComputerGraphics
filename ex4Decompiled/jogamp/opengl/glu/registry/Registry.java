// 
// Decompiled by Procyon v0.5.30
// 

package jogamp.opengl.glu.registry;

public class Registry
{
    public static String gluGetString(final int n) {
        if (n == 100800) {
            return "1.3";
        }
        if (n == 100801) {
            return "GLU_EXT_nurbs_tessellator GLU_EXT_object_space_tess ";
        }
        return null;
    }
    
    public static boolean gluCheckExtension(final String s, final String s2) {
        return s != null && s2 != null && (s2.indexOf(s + " ") >= 0 || s2.endsWith(s) || s2.equals(s));
    }
}
