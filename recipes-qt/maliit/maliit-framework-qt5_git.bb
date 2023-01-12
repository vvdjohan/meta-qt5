DESCRIPTION = "A virtual keyboard for touch-screen based user interfaces"
HOMEPAGE = "https://wiki.maliit.org/Main_Page"

LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://LICENSE.LGPL;md5=5c917f6ce94ceb8d8d5e16e2fca5b9ad"

SRC_URI = "git://github.com/maliit/framework.git;branch=master \
           file://0001-Fix-MALIIT_INSTALL_PRF-to-allow-the-build-with-opene.patch \
           file://maliit-server.desktop \
           file://0001-config.pri-Use-O1-optimization-in-DEBUG-flags.patch \
           file://0001-Drop-tr1-namespace-its-not-there-in-c-11-and-newer.patch \
           file://0001-examples-plugins-Replace-obsolete-screenGeometry.patch \
           "

SRCREV = "60b1b10de14f932420313c547ab801daf522d539"
PV = "0.99.0+git${SRCPV}"

S = "${WORKDIR}/git"

PACKAGES =+ "${PN}-gtk"
GTKIMMODULES_PACKAGES = "${PN}-gtk"

DEPENDS += " \
    qtbase \
    qtdeclarative \
    qtmultimedia \
    qtwayland \
    qtwayland-native \
    glibc \
    glib-2.0-native \
    wayland \
"


inherit cmake_qt5
inherit pkgconfig

 
EXTRA_OECMAKE += " \
    -Denable-docs=OFF \
    -Denable-tests=OFF \
    -Denable-dbus-activation=ON \
    -DQT5_PLUGINS_INSTALL_DIR=${OE_QMAKE_PATH_PLUGINS} \
"


FILES_${PN} += " \
    ${libdir}/plugins \
    ${datadir}/dbus-1/ \
"
 

FILES_${PN}-dev += " \
    ${libdir}/qt5/mkspecs \
"
