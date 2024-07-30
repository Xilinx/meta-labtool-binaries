#
# Copyright (C) 2023, Advanced Micro Devices, Inc. All rights reserved.
# SPDX-License-Identifier: MIT
#

SUMMARY = "Recipe to add 2024.1dev ChipScopy Python Package"
LICENSE = "Apache-2.0 & EPL-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e044f1626fcb471118a71a253d550cb1 \
                    file://epl-v20.html;md5=84283fa8859daf213bdda5a9f8d1be1d \
"

inherit  python3-dir

SRC_URI = "https://files.pythonhosted.org/packages/23/24/14ac5a54c06735ff9cbdf8192a5791e7fbe15f838416b532066667c0a9d6/chipscopy-2024.1.1717799899-py3-none-any.whl;downloadfilename=chipscopy-2024.1.1717799899-py3-none-any.zip;subdir=${BP}"


SRC_URI[md5sum] = "1ed749dd35a8577bdf799b6277727f0f"
SRC_URI[sha256sum] = "a411cc29d78962483a8336f4539b06b276bb6b6990c97521019e0e24e0f4bf2d"

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
    install -d ${D}${libdir}/${PYTHON_DIR}/site-packages/chipscopy-2024.1.1717799899.dist-info
    install -d ${D}${libdir}/${PYTHON_DIR}/site-packages/chipscopy

    cp -r ${S}/chipscopy/* ${D}${libdir}/${PYTHON_DIR}/site-packages/chipscopy/
    cp -r ${S}/chipscopy-2024.1.1717799899.dist-info/* ${D}${libdir}/${PYTHON_DIR}/site-packages/chipscopy-2024.1.1717799899.dist-info/
}
