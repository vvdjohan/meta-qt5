DESCRIPTION = "Plugins for a virtual keyboard for touch-screen based user interfaces"
HOMEPAGE = "https://wiki.maliit.org/Main_Page"

LICENSE = "GPL-3.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

SRC_URI = "\
           git://github.com/maliit/keyboard.git;nobranch=1;protocol=https \
          "
S = "${WORKDIR}/git"

SRCREV = "678e44c8d8111ebf8b170212c07c455f4fcf730c"

DEPENDS += " \
    maliit-framework-qt5 \
    qtbase \
    qtbase-tools \
    qtdeclarative \
    qtmultimedia \
    qtquickcontrols \
    qtquickcontrols2 \
    qtgraphicaleffects \
    qtgraphicaleffects-qmlplugins \
    qtquickcontols-qmlplugins \
    qtdeclarative-qmlplugins \
    glibc \
    hunspell \
    anthy \
"

inherit cmake_qt5
inherit gsettings
inherit gettext
inherit pkgconfig

EXTRA_OECMAKE += "-Denable-presage=OFF"

FILES_${PN} += " \
    ${datadir}/glib-2.0/schemas/org.maliit.keyboard.maliit.gschema.xml \
    ${datadir}/metainfo/com.github.maliit.keyboard.metainfo.xml \
    ${datadir}/maliit/keyboard2/themes \
    ${datadir}/maliit/keyboard2/styles \
    ${datadir}/maliit/keyboard2/icons \
    ${datadir}/maliit/keyboard2/images \
    ${datadir}/maliit/keyboard2/devices \
    ${libdir}/maliit/keyboard2/languages \
    ${libdir}/maliit/keyboard2/qml \
    ${libdir}/maliit/plugins/libmaliit-keyboard-plugin.so \
"
