package com.akamai.botman;

import android.app.Application;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import com.cyberfend.cyfsecurity.SensorDataBuilder;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.common.primitives.UnsignedInts;
import ebk.core.tracking.meridian.constants.MeridianCustomDimensions;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import org.prebid.mobile.rendering.views.webview.mraid.JSInterface;

/* renamed from: com.akamai.botman.h */
/* loaded from: classes.dex */
public final class C2268h {

    /* renamed from: g */
    private static final ArrayList<Integer> f1175g = new ArrayList<>();

    /* renamed from: i */
    private static boolean f1176i = false;

    /* renamed from: j */
    private static boolean f1177j = false;

    /* renamed from: a */
    public C2284u f1178a = null;

    /* renamed from: b */
    public C2271j f1179b = null;

    /* renamed from: c */
    public C2276n f1180c = null;

    /* renamed from: d */
    public C2289w f1181d = null;

    /* renamed from: e */
    private C2263c f1182e = null;

    /* renamed from: f */
    private C2282s f1183f = null;

    /* renamed from: h */
    private AtomicBoolean f1184h = new AtomicBoolean(false);

    /* renamed from: k */
    private boolean f1185k = false;

    /* renamed from: b */
    public static void m7291b() {
        Window$CallbackC2287v.m7253a();
    }

    /* renamed from: g */
    private void m7282g() {
        if (com.cyberfend.cyfsecurity.CYFMonitor.isActivityVisible()) {
            m7283f();
            m7286d();
            m7284e();
            m7288c();
        }
    }

    /* renamed from: c */
    public final void m7288c() {
        try {
            this.f1180c.m7273a();
        } catch (Exception e) {
            C2260ai.m7301c("CYFManager", "Exception in starting orientation manager", e);
            C2266f.m7297a(e);
        }
    }

    /* renamed from: d */
    public final synchronized void m7286d() {
        try {
            this.f1180c.m7271b();
        } catch (Exception e) {
            C2260ai.m7301c("CYFManager", "Exception in stopping orientation manager", e);
            C2266f.m7297a(e);
        }
    }

    /* renamed from: e */
    public final synchronized void m7284e() {
        boolean z;
        boolean z2;
        boolean z3;
        try {
            C2271j c2271j = this.f1179b;
            if (c2271j.f1213d.size() < 128 && !c2271j.f1215f.get()) {
                C2270i c2270i = c2271j.f1210a;
                c2270i.f1188b = c2270i.f1187a.getDefaultSensor(1);
                c2270i.f1189c = c2270i.f1187a.getDefaultSensor(4);
                HandlerThread handlerThread = new HandlerThread("CYFMotionListener");
                c2270i.f1190d = handlerThread;
                handlerThread.start();
                Handler handler = new Handler(c2270i.f1190d.getLooper());
                c2270i.f1192f = c2270i.f1187a.registerListener(c2270i, c2270i.f1188b, 3, handler);
                c2270i.f1193g = c2270i.f1187a.registerListener(c2270i, c2270i.f1189c, 3, handler);
                C2260ai.m7303a("MotionListener", "GyroScope status " + c2270i.f1193g + " and Accelerometer status " + c2270i.f1192f, new Throwable[0]);
                boolean z4 = c2270i.f1192f;
                if (!z4 && !c2270i.f1193g) {
                    C2260ai.m7301c("MotionListener", "Failed to register motion listener", new Throwable[0]);
                    c2270i.m7281a();
                    z3 = false;
                } else {
                    if (!z4) {
                        z = true;
                    } else {
                        z = false;
                    }
                    c2270i.f1195i = z;
                    if (!c2270i.f1193g) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    c2270i.f1194h = z2;
                    c2270i.f1191e = SystemClock.uptimeMillis();
                    c2270i.f1197k = (float) System.nanoTime();
                    c2270i.f1198l = 0;
                    c2270i.f1199m = true;
                    z3 = true;
                }
                if (!z3) {
                    C2260ai.m7301c("MotionManager", "Motion listener registration failed", new Throwable[0]);
                } else {
                    c2271j.f1211b = true;
                    c2271j.f1210a.addObserver(c2271j);
                }
            }
        } catch (Exception e) {
            C2260ai.m7301c("CYFManager", "Exception in starting motion manager", e);
            C2266f.m7297a(e);
        }
    }

    /* renamed from: f */
    public final synchronized void m7283f() {
        try {
            this.f1179b.m7280a();
        } catch (Exception e) {
            C2260ai.m7301c("CYFManager", "Exception in stopping motion manager", e);
            C2266f.m7297a(e);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(42:12|(1:14)|15|(1:17)|18|(1:20)|21|22|23|(1:25)|26|(3:30|(1:32)(1:42)|(6:34|(1:36)|37|38|39|40))|43|(1:45)(1:114)|46|(1:48)(2:111|(1:113))|49|50|(1:52)(2:107|(1:109)(1:110))|53|(1:55)(1:106)|56|(1:58)(1:105)|59|(1:61)(1:104)|62|(1:103)|66|67|68|(3:70|(1:74)|75)|76|(3:78|(1:82)|83)|84|(2:86|(3:88|(1:92)|93))|94|(1:96)|97|98|38|39|40) */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0541, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0543, code lost:
        com.akamai.botman.C2266f.m7297a(r0);
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized String m7296a() {
        String str;
        String str2;
        C2260ai.m7303a("CYFManager", "Getting sensor data", new Throwable[0]);
        try {
            try {
            } catch (Exception e) {
                e = e;
                Exception exc = e;
                C2260ai.m7301c("CYFManager", "Failed to get sensor data", exc);
                C2266f.m7297a(exc);
                str = "default-mobile";
                C2260ai.m7303a("CYFManager", "Sensor Data: ".concat(String.valueOf(str)), new Throwable[0]);
                return str;
            }
        } catch (Exception e2) {
            e = e2;
        }
        if (this.f1179b != null && this.f1180c != null) {
            C2260ai.m7303a("CYFManager", "Building sensor data: " + Thread.currentThread(), new Throwable[0]);
            long uptimeMillis = SystemClock.uptimeMillis();
            if (C2265e.f1170c.equals("default_performance")) {
                C2265e.f1170c = C2278o.m7267a();
            }
            String str3 = JSInterface.LOCATION_ERROR;
            String str4 = "";
            C2282s c2282s = this.f1183f;
            if (c2282s != null) {
                str3 = c2282s.f1261b;
                str4 = C2282s.m7258a();
            }
            String str5 = str3 + "," + C2280q.m7265a(str3) + "," + String.valueOf(new Random().nextInt()) + "," + String.valueOf(C2264d.f1161a / 2);
            C2261aj<Pair<String, String>, Long, Long> m7269d = this.f1180c.m7269d();
            C2261aj<Pair<String, String>, Long, Long> m7277c = this.f1179b.m7277c();
            String m7270c = this.f1180c.m7270c();
            String m7278b = this.f1179b.m7278b();
            Pair<String, Long> pair = new Pair<>("", 0L);
            C2289w c2289w = this.f1181d;
            if (c2289w != null) {
                pair = c2289w.m7249a();
            }
            Pair<String, Long> pair2 = new Pair<>("", 0L);
            C2284u c2284u = this.f1178a;
            if (c2284u != null) {
                pair2 = c2284u.m7256b();
            }
            if (m7269d.f1158c.longValue() < 32 && m7277c.f1158c.longValue() < 32) {
                if (C2250aa.m7322a().f1143b != null) {
                    String str6 = C2250aa.m7322a().f1143b;
                    if (this.f1184h.compareAndSet(false, true)) {
                        C2260ai.m7301c("CYFManager", "Refresh Sensor data", new Throwable[0]);
                        new Timer().schedule(new TimerTask() { // from class: com.akamai.botman.h.1
                            @Override // java.util.TimerTask, java.lang.Runnable
                            public final void run() {
                                C2268h.this.m7296a();
                                C2268h.this.f1184h.compareAndSet(true, false);
                            }
                        }, 5000L);
                    }
                    str = str6 + "$" + C2295z.m7222f().m7221g() + "$" + C2292y.m7246a().m7244b();
                    m7282g();
                    C2260ai.m7303a("CYFManager", "Sensor Data: ".concat(String.valueOf(str)), new Throwable[0]);
                    return str;
                }
            }
            String str7 = (String) pair2.first;
            String str8 = (String) pair.first;
            String str9 = C2265e.f1168a;
            C2263c c2263c = this.f1182e;
            String m7300a = c2263c != null ? c2263c.m7300a() : "";
            String str10 = "do_en";
            C2276n c2276n = this.f1180c;
            if (c2276n.f1252a.f1237a) {
                str10 = "do_unr";
            } else if (!c2276n.f1253b) {
                str10 = "do_dis";
            }
            String str11 = str10;
            C2271j c2271j = this.f1179b;
            if (c2271j.f1210a.f1196j) {
                str2 = "dm_unr";
            } else {
                str2 = !c2271j.f1211b ? "dm_dis" : "dm_en";
            }
            String str12 = str11 + "," + str2 + ",t_en";
            long uptimeMillis2 = (SystemClock.uptimeMillis() - uptimeMillis) * 1000;
            int i = Looper.myLooper() != Looper.getMainLooper() ? 1 : 0;
            boolean m7250b = Window$CallbackC2287v.m7250b();
            String str13 = m7300a;
            long longValue = ((Long) pair2.second).longValue() + ((Long) pair.second).longValue() + m7269d.f1157b.longValue() + m7277c.f1157b.longValue();
            long currentTimeMillis = System.currentTimeMillis() - C2264d.f1161a;
            C2284u c2284u2 = this.f1178a;
            long j = c2284u2 != null ? c2284u2.f1272f : 0L;
            C2289w c2289w2 = this.f1181d;
            Pair<String, Long> pair3 = pair;
            Pair<String, Long> pair4 = pair2;
            long j2 = c2289w2 != null ? c2289w2.f1286d : 0L;
            String str14 = str4;
            String str15 = pair4.second + "," + pair3.second + "," + m7269d.f1157b + "," + m7277c.f1157b + "," + longValue + "," + currentTimeMillis + "," + j + "," + j2 + "," + m7269d.f1158c + "," + m7277c.f1158c + "," + (C2264d.f1166f * 1000) + "," + uptimeMillis2 + "," + C2264d.f1167g + "," + C2254ac.m7316a((((int) (j + j2 + m7269d.f1158c.longValue() + m7277c.f1158c.longValue())) & UnsignedInts.INT_MASK) | (((int) longValue) << 32), (int) currentTimeMillis) + "," + C2264d.f1161a;
            Pair<String, String> pair5 = m7269d.f1156a;
            Pair<String, String> pair6 = m7277c.f1156a;
            ArrayList<Pair<String, String>> arrayList = new ArrayList<>();
            arrayList.add(new Pair<>("", "3.3.1"));
            arrayList.add(new Pair<>("-70", ""));
            arrayList.add(new Pair<>("-80", ""));
            arrayList.add(new Pair<>("-100", str5));
            arrayList.add(new Pair<>("-104", str14));
            arrayList.add(new Pair<>("-101", str12));
            arrayList.add(new Pair<>("-102", str9));
            arrayList.add(new Pair<>("-103", str13));
            arrayList.add(new Pair<>("-108", str7));
            arrayList.add(new Pair<>("-112", C2265e.f1170c));
            arrayList.add(new Pair<>("-115", str15));
            arrayList.add(new Pair<>("-117", str8));
            arrayList.add(new Pair<>("-120", C2265e.f1169b));
            arrayList.add(new Pair<>("-121", ""));
            arrayList.add(new Pair<>("-144", (String) pair5.second));
            arrayList.add(new Pair<>("-160", m7270c));
            arrayList.add(new Pair<>("-142", (String) pair5.first));
            arrayList.add(new Pair<>("-145", (String) pair6.second));
            arrayList.add(new Pair<>("-161", m7278b));
            arrayList.add(new Pair<>("-143", (String) pair6.first));
            arrayList.add(new Pair<>("-150", i + "," + (m7250b ? 1 : 0)));
            C2260ai.m7303a("CYFManager", "Plain-BuildSensorData-Time: " + (SystemClock.uptimeMillis() - uptimeMillis) + "ms", new Throwable[0]);
            String buildN = SensorDataBuilder.m6218a().buildN(arrayList);
            if (m7269d.f1158c.longValue() >= 32 || m7277c.f1158c.longValue() >= 32) {
                final C2250aa m7322a = C2250aa.m7322a();
                m7322a.f1143b = buildN;
                new Thread(new Runnable() { // from class: com.akamai.botman.aa.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        C2250aa.this.m7317c();
                    }
                }).start();
            }
            str = buildN + "$" + C2295z.m7222f().m7221g() + "$" + C2292y.m7246a().m7244b();
            C2276n c2276n2 = this.f1180c;
            c2276n2.f1254c = SystemClock.uptimeMillis();
            c2276n2.f1255d.clear();
            Future<C2261aj<Pair<String, String>, Long, Long>> future = c2276n2.f1257f;
            if (future != null) {
                if (!future.isCancelled() && !c2276n2.f1257f.isDone()) {
                    c2276n2.f1257f.cancel(true);
                }
                c2276n2.f1257f = null;
            }
            c2276n2.f1256e.clear();
            C2271j c2271j2 = this.f1179b;
            c2271j2.f1212c = SystemClock.uptimeMillis();
            c2271j2.f1213d.clear();
            Future<C2261aj<Pair<String, String>, Long, Long>> future2 = c2271j2.f1214e;
            if (future2 != null) {
                if (!future2.isCancelled() && !c2271j2.f1214e.isDone()) {
                    c2271j2.f1214e.cancel(true);
                }
                c2271j2.f1214e = null;
            }
            c2271j2.f1216g.clear();
            C2289w c2289w3 = this.f1181d;
            if (c2289w3 != null) {
                c2289w3.f1284b = 0;
                c2289w3.f1285c = 0;
                c2289w3.f1286d = 0L;
                c2289w3.f1287e = "";
                c2289w3.f1290h = 0L;
                c2289w3.f1283a = SystemClock.uptimeMillis();
                c2289w3.f1288f.clear();
                Future<Pair<String, Long>> future3 = c2289w3.f1289g;
                if (future3 != null) {
                    if (!future3.isCancelled() && !c2289w3.f1289g.isDone()) {
                        c2289w3.f1289g.cancel(true);
                    }
                    c2289w3.f1289g = null;
                }
            }
            C2284u c2284u3 = this.f1178a;
            if (c2284u3 != null) {
                c2284u3.m7257a();
            }
            C2265e.m7298a();
            C2264d.m7299a();
            m7282g();
            C2260ai.m7303a("CYFManager", "Sensor Data: ".concat(String.valueOf(str)), new Throwable[0]);
            return str;
        }
        C2260ai.m7301c("CYFManager", "AkamaiBMP SDK is not initialized", new Throwable[0]);
        return "default-mobile";
    }

    /* renamed from: b */
    public final void m7289b(Window window) {
        try {
            if (this.f1181d == null) {
                this.f1181d = new C2289w();
            }
            C2289w c2289w = this.f1181d;
            C2260ai.m7303a("TouchManager", "Listening on window", new Throwable[0]);
            c2289w.f1283a = SystemClock.uptimeMillis();
            c2289w.f1284b = 0;
            c2289w.f1285c = 0;
            Window$CallbackC2287v window$CallbackC2287v = new Window$CallbackC2287v(window.getCallback());
            window.setCallback(window$CallbackC2287v);
            window$CallbackC2287v.addObserver(c2289w);
        } catch (Exception e) {
            C2260ai.m7301c("CYFManager", "Exception in creating touch manager", e);
            C2266f.m7297a(e);
        }
    }

    /* renamed from: c */
    public final synchronized void m7287c(Application application) {
        if (!f1177j) {
            C2263c c2263c = new C2263c();
            this.f1182e = c2263c;
            application.registerActivityLifecycleCallbacks(c2263c);
            f1177j = true;
        }
    }

    /* renamed from: d */
    public final synchronized void m7285d(Application application) {
        if (!f1176i && application != null) {
            try {
                C2282s c2282s = new C2282s();
                this.f1183f = c2282s;
                long uptimeMillis = SystemClock.uptimeMillis();
                c2282s.f1261b = C2281r.m7261a(application);
                C2264d.f1166f = SystemClock.uptimeMillis() - uptimeMillis;
                C2260ai.m7303a("CYFSystemInfoManager", "DeviceInfo-Time: " + C2264d.f1166f + "ms", new Throwable[0]);
                f1176i = true;
            } catch (Exception e) {
                C2266f.m7297a(e);
            }
        }
    }

    /* renamed from: b */
    public final synchronized void m7290b(Application application) {
        if (this.f1179b != null) {
            return;
        }
        this.f1179b = new C2271j(application);
    }

    /* renamed from: a */
    public static synchronized boolean m7293a(Window window) {
        synchronized (C2268h.class) {
            int hashCode = window.hashCode();
            int i = 0;
            while (true) {
                ArrayList<Integer> arrayList = f1175g;
                if (i < arrayList.size()) {
                    if (hashCode == arrayList.get(i).intValue()) {
                        return true;
                    }
                    i++;
                } else {
                    arrayList.add(Integer.valueOf(hashCode));
                    return false;
                }
            }
        }
    }

    /* renamed from: a */
    public final void m7294a(ViewGroup viewGroup) {
        try {
            ArrayList<View> m7266a = C2279p.m7266a(viewGroup);
            for (int i = 0; i < m7266a.size(); i++) {
                View view = m7266a.get(i);
                if (view instanceof EditText) {
                    if (!this.f1185k) {
                        this.f1178a = new C2284u();
                        this.f1185k = true;
                    }
                    C2284u c2284u = this.f1178a;
                    EditText editText = (EditText) view;
                    C2260ai.m7303a("TextChangeManager", "Listening on edit text: " + editText.getId(), new Throwable[0]);
                    int m7265a = C2280q.m7265a(String.valueOf(editText.getId()));
                    if (!C2265e.f1168a.toLowerCase().contains(Integer.toString(m7265a).toLowerCase())) {
                        C2265e.f1168a += m7265a + ";";
                    }
                    if ((editText.getInputType() & 129) != 129 && (editText.getInputType() & 18) != 18 && (editText.getInputType() & MeridianCustomDimensions.PreviousPageType) != 145 && (editText.getInputType() & HideBottomViewOnScrollBehavior.ENTER_ANIMATION_DURATION) != 225) {
                        C2283t c2283t = new C2283t(m7265a, false);
                        editText.addTextChangedListener(c2283t);
                        c2283t.addObserver(c2284u.f1267a);
                    }
                    C2283t c2283t2 = new C2283t(m7265a, true);
                    editText.addTextChangedListener(c2283t2);
                    c2283t2.addObserver(c2284u.f1267a);
                }
            }
        } catch (Exception e) {
            C2260ai.m7301c("CYFManager", "Exception in creating text listener", e);
            C2266f.m7297a(e);
        }
    }

    /* renamed from: a */
    public final synchronized void m7295a(Application application) {
        if (this.f1180c != null) {
            return;
        }
        this.f1180c = new C2276n(application);
    }
}
