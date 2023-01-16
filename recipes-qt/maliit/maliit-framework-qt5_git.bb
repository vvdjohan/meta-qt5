DESCRIPTION = "A virtual keyboard for touch-screen based user interfaces"
HOMEPAGE = "https://wiki.maliit.org/Main_Page"

LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://LICENSE.LGPL;md5=d32239bcb673463ab874e80d47fae504"

inherit qmake5 qmake5_paths

SRC_URI = " \
           git://github.com/maliit/framework.git;nobranch=1;protocol=https \
           "

S = "${WORKDIR}/git"

SRCREV = "812969485050b5329294b37648a11ba60e0be430"

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
