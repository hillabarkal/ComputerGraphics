// 
// Decompiled by Procyon v0.5.30
// 

package jogamp.newt.driver.macosx;

public class MacKeyUtil
{
    private static final short kVK_ANSI_A = 0;
    private static final short kVK_ANSI_S = 1;
    private static final short kVK_ANSI_D = 2;
    private static final short kVK_ANSI_F = 3;
    private static final short kVK_ANSI_H = 4;
    private static final short kVK_ANSI_G = 5;
    private static final short kVK_ANSI_Z = 6;
    private static final short kVK_ANSI_X = 7;
    private static final short kVK_ANSI_C = 8;
    private static final short kVK_ANSI_V = 9;
    private static final short kVK_ANSI_B = 11;
    private static final short kVK_ANSI_Q = 12;
    private static final short kVK_ANSI_W = 13;
    private static final short kVK_ANSI_E = 14;
    private static final short kVK_ANSI_R = 15;
    private static final short kVK_ANSI_Y = 16;
    private static final short kVK_ANSI_T = 17;
    private static final short kVK_ANSI_1 = 18;
    private static final short kVK_ANSI_2 = 19;
    private static final short kVK_ANSI_3 = 20;
    private static final short kVK_ANSI_4 = 21;
    private static final short kVK_ANSI_6 = 22;
    private static final short kVK_ANSI_5 = 23;
    private static final short kVK_ANSI_Equal = 24;
    private static final short kVK_ANSI_9 = 25;
    private static final short kVK_ANSI_7 = 26;
    private static final short kVK_ANSI_Minus = 27;
    private static final short kVK_ANSI_8 = 28;
    private static final short kVK_ANSI_0 = 29;
    private static final short kVK_ANSI_RightBracket = 30;
    private static final short kVK_ANSI_O = 31;
    private static final short kVK_ANSI_U = 32;
    private static final short kVK_ANSI_LeftBracket = 33;
    private static final short kVK_ANSI_I = 34;
    private static final short kVK_ANSI_P = 35;
    private static final short kVK_ANSI_L = 37;
    private static final short kVK_ANSI_J = 38;
    private static final short kVK_ANSI_Quote = 39;
    private static final short kVK_ANSI_K = 40;
    private static final short kVK_ANSI_Semicolon = 41;
    private static final short kVK_ANSI_Backslash = 42;
    private static final short kVK_ANSI_Comma = 43;
    private static final short kVK_ANSI_Slash = 44;
    private static final short kVK_ANSI_N = 45;
    private static final short kVK_ANSI_M = 46;
    private static final short kVK_ANSI_Period = 47;
    private static final short kVK_ANSI_Grave = 50;
    private static final short kVK_ANSI_KeypadDecimal = 65;
    private static final short kVK_ANSI_KeypadMultiply = 67;
    private static final short kVK_ANSI_KeypadPlus = 69;
    private static final short kVK_ANSI_KeypadClear = 71;
    private static final short kVK_ANSI_KeypadDivide = 75;
    private static final short kVK_ANSI_KeypadEnter = 76;
    private static final short kVK_ANSI_KeypadMinus = 78;
    private static final short kVK_ANSI_KeypadEquals = 81;
    private static final short kVK_ANSI_Keypad0 = 82;
    private static final short kVK_ANSI_Keypad1 = 83;
    private static final short kVK_ANSI_Keypad2 = 84;
    private static final short kVK_ANSI_Keypad3 = 85;
    private static final short kVK_ANSI_Keypad4 = 86;
    private static final short kVK_ANSI_Keypad5 = 87;
    private static final short kVK_ANSI_Keypad6 = 88;
    private static final short kVK_ANSI_Keypad7 = 89;
    private static final short kVK_ANSI_Keypad8 = 91;
    private static final short kVK_ANSI_Keypad9 = 92;
    private static final short kVK_Return = 36;
    private static final short kVK_Tab = 48;
    private static final short kVK_Space = 49;
    private static final short kVK_Delete = 51;
    private static final short kVK_Escape = 53;
    private static final short kVK_Command = 55;
    private static final short kVK_Shift = 56;
    private static final short kVK_CapsLock = 57;
    private static final short kVK_Option = 58;
    private static final short kVK_Control = 59;
    private static final short kVK_RightShift = 60;
    private static final short kVK_RightOption = 61;
    private static final short kVK_RightControl = 62;
    private static final short kVK_F17 = 64;
    private static final short kVK_F18 = 79;
    private static final short kVK_F19 = 80;
    private static final short kVK_F20 = 90;
    private static final short kVK_F5 = 96;
    private static final short kVK_F6 = 97;
    private static final short kVK_F7 = 98;
    private static final short kVK_F3 = 99;
    private static final short kVK_F8 = 100;
    private static final short kVK_F9 = 101;
    private static final short kVK_F11 = 103;
    private static final short kVK_F13 = 105;
    private static final short kVK_F16 = 106;
    private static final short kVK_F14 = 107;
    private static final short kVK_F10 = 109;
    private static final short kVK_F12 = 111;
    private static final short kVK_F15 = 113;
    private static final short kVK_Help = 114;
    private static final short kVK_Home = 115;
    private static final short kVK_PageUp = 116;
    private static final short kVK_ForwardDelete = 117;
    private static final short kVK_F4 = 118;
    private static final short kVK_End = 119;
    private static final short kVK_F2 = 120;
    private static final short kVK_PageDown = 121;
    private static final short kVK_F1 = 122;
    private static final short kVK_LeftArrow = 123;
    private static final short kVK_RightArrow = 124;
    private static final short kVK_DownArrow = 125;
    private static final short kVK_UpArrow = 126;
    private static final char NSUpArrowFunctionKey = '\uf700';
    private static final char NSDownArrowFunctionKey = '\uf701';
    private static final char NSLeftArrowFunctionKey = '\uf702';
    private static final char NSRightArrowFunctionKey = '\uf703';
    private static final char NSF1FunctionKey = '\uf704';
    private static final char NSF2FunctionKey = '\uf705';
    private static final char NSF3FunctionKey = '\uf706';
    private static final char NSF4FunctionKey = '\uf707';
    private static final char NSF5FunctionKey = '\uf708';
    private static final char NSF6FunctionKey = '\uf709';
    private static final char NSF7FunctionKey = '\uf70a';
    private static final char NSF8FunctionKey = '\uf70b';
    private static final char NSF9FunctionKey = '\uf70c';
    private static final char NSF10FunctionKey = '\uf70d';
    private static final char NSF11FunctionKey = '\uf70e';
    private static final char NSF12FunctionKey = '\uf70f';
    private static final char NSF13FunctionKey = '\uf710';
    private static final char NSF14FunctionKey = '\uf711';
    private static final char NSF15FunctionKey = '\uf712';
    private static final char NSF16FunctionKey = '\uf713';
    private static final char NSF17FunctionKey = '\uf714';
    private static final char NSF18FunctionKey = '\uf715';
    private static final char NSF19FunctionKey = '\uf716';
    private static final char NSF20FunctionKey = '\uf717';
    private static final char NSF21FunctionKey = '\uf718';
    private static final char NSF22FunctionKey = '\uf719';
    private static final char NSF23FunctionKey = '\uf71a';
    private static final char NSF24FunctionKey = '\uf71b';
    private static final char NSInsertFunctionKey = '\uf727';
    private static final char NSDeleteFunctionKey = '\uf728';
    private static final char NSHomeFunctionKey = '\uf729';
    private static final char NSBeginFunctionKey = '\uf72a';
    private static final char NSEndFunctionKey = '\uf72b';
    private static final char NSPageUpFunctionKey = '\uf72c';
    private static final char NSPageDownFunctionKey = '\uf72d';
    private static final char NSPrintScreenFunctionKey = '\uf72e';
    private static final char NSScrollLockFunctionKey = '\uf72f';
    private static final char NSPauseFunctionKey = '\uf730';
    private static final char NSStopFunctionKey = '\uf734';
    
    static short validateKeyCode(final short n, final char c) {
        switch (n) {
            case 0: {
                return 65;
            }
            case 1: {
                return 83;
            }
            case 2: {
                return 68;
            }
            case 3: {
                return 70;
            }
            case 4: {
                return 72;
            }
            case 5: {
                return 71;
            }
            case 6: {
                return 90;
            }
            case 7: {
                return 88;
            }
            case 8: {
                return 67;
            }
            case 9: {
                return 86;
            }
            case 11: {
                return 66;
            }
            case 12: {
                return 81;
            }
            case 13: {
                return 87;
            }
            case 14: {
                return 69;
            }
            case 15: {
                return 82;
            }
            case 16: {
                return 89;
            }
            case 17: {
                return 84;
            }
            case 18: {
                return 49;
            }
            case 19: {
                return 50;
            }
            case 20: {
                return 51;
            }
            case 21: {
                return 52;
            }
            case 22: {
                return 54;
            }
            case 23: {
                return 53;
            }
            case 24: {
                return 61;
            }
            case 25: {
                return 57;
            }
            case 26: {
                return 55;
            }
            case 27: {
                return 45;
            }
            case 28: {
                return 56;
            }
            case 29: {
                return 48;
            }
            case 30: {
                return 93;
            }
            case 31: {
                return 79;
            }
            case 32: {
                return 85;
            }
            case 33: {
                return 91;
            }
            case 34: {
                return 73;
            }
            case 35: {
                return 80;
            }
            case 37: {
                return 76;
            }
            case 38: {
                return 74;
            }
            case 39: {
                return 39;
            }
            case 40: {
                return 75;
            }
            case 41: {
                return 59;
            }
            case 42: {
                return 92;
            }
            case 43: {
                return 44;
            }
            case 44: {
                return 47;
            }
            case 45: {
                return 78;
            }
            case 46: {
                return 77;
            }
            case 47: {
                return 46;
            }
            case 50: {
                return 96;
            }
            case 65: {
                return 138;
            }
            case 67: {
                return 141;
            }
            case 69: {
                return 43;
            }
            case 71: {
                return 12;
            }
            case 75: {
                return 142;
            }
            case 76: {
                return 13;
            }
            case 78: {
                return 45;
            }
            case 81: {
                return 61;
            }
            case 82: {
                return 48;
            }
            case 83: {
                return 49;
            }
            case 84: {
                return 50;
            }
            case 85: {
                return 51;
            }
            case 86: {
                return 52;
            }
            case 87: {
                return 53;
            }
            case 88: {
                return 54;
            }
            case 89: {
                return 55;
            }
            case 91: {
                return 56;
            }
            case 92: {
                return 57;
            }
            case 36: {
                return 13;
            }
            case 48: {
                return 9;
            }
            case 49: {
                return 32;
            }
            case 51: {
                return 8;
            }
            case 53: {
                return 27;
            }
            case 55: {
                return 154;
            }
            case 56: {
                return 15;
            }
            case 57: {
                return 20;
            }
            case 58: {
                return 18;
            }
            case 59: {
                return 17;
            }
            case 60: {
                return 15;
            }
            case 61: {
                return 19;
            }
            case 62: {
                return 17;
            }
            case 64: {
                return 113;
            }
            case 79: {
                return 114;
            }
            case 80: {
                return 115;
            }
            case 90: {
                return 116;
            }
            case 96: {
                return 101;
            }
            case 97: {
                return 102;
            }
            case 98: {
                return 103;
            }
            case 99: {
                return 99;
            }
            case 100: {
                return 104;
            }
            case 101: {
                return 105;
            }
            case 103: {
                return 107;
            }
            case 105: {
                return 109;
            }
            case 106: {
                return 112;
            }
            case 107: {
                return 110;
            }
            case 109: {
                return 106;
            }
            case 111: {
                return 108;
            }
            case 113: {
                return 111;
            }
            case 114: {
                return 156;
            }
            case 115: {
                return 2;
            }
            case 116: {
                return 16;
            }
            case 117: {
                return 147;
            }
            case 118: {
                return 100;
            }
            case 119: {
                return 3;
            }
            case 120: {
                return 98;
            }
            case 121: {
                return 11;
            }
            case 122: {
                return 97;
            }
            case 123: {
                return 149;
            }
            case 124: {
                return 151;
            }
            case 125: {
                return 152;
            }
            case 126: {
                return 150;
            }
            default: {
                switch (c) {
                    case '\uf700': {
                        return 150;
                    }
                    case '\uf701': {
                        return 152;
                    }
                    case '\uf702': {
                        return 149;
                    }
                    case '\uf703': {
                        return 151;
                    }
                    case '\uf704': {
                        return 97;
                    }
                    case '\uf705': {
                        return 98;
                    }
                    case '\uf706': {
                        return 99;
                    }
                    case '\uf707': {
                        return 100;
                    }
                    case '\uf708': {
                        return 101;
                    }
                    case '\uf709': {
                        return 102;
                    }
                    case '\uf70a': {
                        return 103;
                    }
                    case '\uf70b': {
                        return 104;
                    }
                    case '\uf70c': {
                        return 105;
                    }
                    case '\uf70d': {
                        return 106;
                    }
                    case '\uf70e': {
                        return 107;
                    }
                    case '\uf70f': {
                        return 108;
                    }
                    case '\uf710': {
                        return 109;
                    }
                    case '\uf711': {
                        return 110;
                    }
                    case '\uf712': {
                        return 111;
                    }
                    case '\uf713': {
                        return 112;
                    }
                    case '\uf714': {
                        return 113;
                    }
                    case '\uf715': {
                        return 114;
                    }
                    case '\uf716': {
                        return 115;
                    }
                    case '\uf717': {
                        return 116;
                    }
                    case '\uf718': {
                        return 117;
                    }
                    case '\uf719': {
                        return 118;
                    }
                    case '\uf71a': {
                        return 119;
                    }
                    case '\uf71b': {
                        return 120;
                    }
                    case '\uf727': {
                        return 26;
                    }
                    case '\uf728': {
                        return 147;
                    }
                    case '\uf729': {
                        return 2;
                    }
                    case '\uf72a': {
                        return 158;
                    }
                    case '\uf72b': {
                        return 3;
                    }
                    case '\uf72c': {
                        return 16;
                    }
                    case '\uf72d': {
                        return 11;
                    }
                    case '\uf72e': {
                        return 5;
                    }
                    case '\uf72f': {
                        return 23;
                    }
                    case '\uf730': {
                        return 22;
                    }
                    case '\uf734': {
                        return 159;
                    }
                    default: {
                        return (short)c;
                    }
                }
                break;
            }
        }
    }
}
