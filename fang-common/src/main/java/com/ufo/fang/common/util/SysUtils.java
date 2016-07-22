package com.ufo.fang.common.util;

import java.lang.management.ManagementFactory;
import java.net.*;
import java.nio.charset.Charset;
import java.util.*;

/***
 * Describe
 *
 * @author hekang
 * @created 2016/7/19
 */
public class SysUtils {

    public static final Charset UTF_8 = Charset.forName("UTF-8");
    public static final Charset ISO8859_1 = Charset.forName("ISO8859-1");
    public static final Charset GBK = Charset.forName("GBK");
    public static Set<String> BASE_SHELL_VAR = Collections.unmodifiableSet(new HashSet(StringUtils.splitToList("SSH_CLIENT, MAIL, NLSPATH, XDG_SESSION_ID, SSH_AGENT_PID, XFILESEARCHPATH, SSH_TTY,SSH_CONNECTION, XDG_RUNTIME_DIR, GLADE_PIXMAP_PATH, TERM, SHELL, XDG_MENU_PREFIX, XDG_SESSION_COOKIE,WINDOWID, USER, LS_COLORS, XDG_SESSION_PATH, GLADE_MODULE_PATH, XDG_SEAT_PATH,SSH_AUTH_SOCK, SESSION_MANAGER, DEFAULTS_PATH, XDG_CONFIG_DIRS, PATH, DESKTOP_SESSION,QT_IM_MODULE, PWD, XMODIFIERS, LANG, MANDATORY_PATH, GDMSESSION, SHLVL, HOME, LANGUAGE,LOGNAME, XDG_DATA_DIRS, DBUS_SESSION_BUS_ADDRESS, LESSOPEN, DISPLAY, GLADE_CATALOG_PATH,LIBGLADE_MODULE_PATH, XDG_CURRENT_DESKTOP, GTK_IM_MODULE, LESSCLOSE, COLORTERM, XAUTHORITY,OLDPWD, _", ',')));
    private static Integer jvmPid;

    public SysUtils() {
    }

    public static Integer getJvmPid() {
        if(jvmPid == null) {
            jvmPid = Integer.valueOf(ManagementFactory.getRuntimeMXBean().getName().split("@", 2)[0]);
        }

        return jvmPid;
    }
}
