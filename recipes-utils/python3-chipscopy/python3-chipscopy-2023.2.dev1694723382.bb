#
# Copyright (C) 2023, Advanced Micro Devices, Inc. All rights reserved.
# SPDX-License-Identifier: MIT
#

SUMMARY = "Recipe to add 2022.1 ChipScopy Python Package"
LICENSE = "Apache-2.0 & EPL-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e044f1626fcb471118a71a253d550cb1 \
                    file://epl-v20.html;md5=84283fa8859daf213bdda5a9f8d1be1d \
"

inherit  python3-dir

SRC_URI = "https://files.pythonhosted.org/packages/bc/08/ca0e882566012b2cf539449d609b6ff3e26808011815974173b44be765ee/chipscopy-2023.2.dev1694723382-py3-none-any.whl;downloadfilename=chipscopy-2023.2.dev1694723382-py3-none-any.zip;subdir=${BP}"


SRC_URI[md5sum] = "4aa5db2c4be84e4097c93c4b75e7e6bd"
SRC_URI[sha256sum] = "a341ddfc13a8036ca707223ddb4e650e63ba126f513ce55636e0b37b464864d7"

PN = "python3-chipscopy"

RDEPENDS:${PN} += " \
        ${PYTHON_PN}-click \
        ${PYTHON_PN}-importlib-metadata \
        ${PYTHON_PN}-loguru \
        ${PYTHON_PN}-more-itertools \
        ${PYTHON_PN}-rich \
        ${PYTHON_PN}-typing-extensions \
        ${PYTHON_PN}-pprint \
        ${PYTHON_PN}-json \
        ${PYTHON_PN}-matplotlib \
        ${PYTHON_PN}-plotly \
        ${PYTHON_PN}-regex \
        ${PYTHON_PN}-pandas \
        "

DEPENDS += " \
	python3-wheel-native \
	python3-pip-native \
"

FILES:${PN} += "\
    ${libdir}/${PYTHON_DIR}/site-packages/* \
"

do_install() {
    install -d ${D}${libdir}/${PYTHON_DIR}/site-packages/chipscopy-2023.2.dev1694723382.dist-info
    install -d ${D}${libdir}/${PYTHON_DIR}/site-packages/chipscopy

    cp -r ${S}/chipscopy/* ${D}${libdir}/${PYTHON_DIR}/site-packages/chipscopy/
    cp -r ${S}/chipscopy-2023.2.dev1694723382.dist-info/* ${D}${libdir}/${PYTHON_DIR}/site-packages/chipscopy-2023.2.dev1694723382.dist-info/
}
