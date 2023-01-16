DESCRIPTION = "A virtual keyboard for touch-screen based user interfaces"
HOMEPAGE = "https://wiki.maliit.org/Main_Page"

LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://LICENSE.LGPL;md5=5c917f6ce94ceb8d8d5e16e2fca5b9ad"

inherit qmake5 qmake5_paths

SRC_URI = " \
           git://github.com/maliit/framework.git;nobranch=1;protocol=https \
           "

S = "${WORKDIR}/git"

SRCREV = "a478e92832a595519d1acca78580789a6c77d972"

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
