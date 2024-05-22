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

SRC_URI = "https://files.pythonhosted.org/packages/0c/d5/559e0a2a384acd1364461b49043c6757ef14f0df4cb321e90aa11a9c439e/chipscopy-2024.1.dev1715183651-py3-none-any.whl;downloadfilename=chipscopy-2024.1.dev1715183651-py3-none-any.zip;subdir=${BP}"


SRC_URI[md5sum] = "0a7ea4300b25600e8db4df46bf18d5f2"
SRC_URI[sha256sum] = "8b5b4755332da5ce5397e1a067851e0c126cabe4bcda5cd3787199c3da99b46e"

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
    install -d ${D}${libdir}/${PYTHON_DIR}/site-packages/chipscopy-2024.1.dev1715183651.dist-info
    install -d ${D}${libdir}/${PYTHON_DIR}/site-packages/chipscopy

    cp -r ${S}/chipscopy/* ${D}${libdir}/${PYTHON_DIR}/site-packages/chipscopy/
    cp -r ${S}/chipscopy-2024.1.dev1715183651.dist-info/* ${D}${libdir}/${PYTHON_DIR}/site-packages/chipscopy-2024.1.dev1715183651.dist-info/
}
