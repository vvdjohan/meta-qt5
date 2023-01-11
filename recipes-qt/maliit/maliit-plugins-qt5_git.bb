DESCRIPTION = "Plugins for a virtual keyboard for touch-screen based user interfaces"
HOMEPAGE = "https://wiki.maliit.org/Main_Page"

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f29b21caa8e460097bfad9c026a33621"

inherit qmake5

DEPENDS = "maliit-framework-qt5"

RDEPENDS_${PN} += "qtsvg-plugins"

SRC_URI = "git://github.com/maliit/keyboard.git;branch=master \
           file://0001-Do-not-use-tr1-namespace.patch \
          "

SRCREV = "678e44c8d8111ebf8b170212c07c455f4fcf730c"
PV = "2.3.0+git${SRCPV}"


EXTRA_QMAKEVARS_PRE = "\
    PREFIX=${prefix} \
    MALIIT_INSTALL_PRF=${QMAKE_MKSPEC_PATH}/mkspecs/features \
    MALIIT_PLUGINS_DATA_DIR=${datadir} \
    LIBDIR=${libdir} \
    CONFIG+=nodoc \
"

# tests fail to build with clang
EXTRA_QMAKEVARS_PRE_append_toolchain-clang = " CONFIG+=notests"

FILES_${PN} += "\
    ${libdir}/maliit \
    ${datadir} \
"

S= "${WORKDIR}/git"

EXTRA_OEMAKE += "INSTALL_ROOT=${D}"
