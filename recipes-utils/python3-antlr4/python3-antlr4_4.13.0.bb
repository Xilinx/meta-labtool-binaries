#
# Copyright (C) 2023, Advanced Micro Devices, Inc. All rights reserved.
# SPDX-License-Identifier: MIT
#

SUMMARY = "Recipe to embedded antrl4 Python Package"
HOMEPAGE ="https://pypi.org/project/antlr4-python3-runtime"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://PKG-INFO;md5=b38bac4871765ce562806c44d2f18cf1"

inherit pypi python_setuptools_build_meta

PYPI_PACKAGE = "antlr4-python3-runtime"

SRC_URI[md5sum] = "8ff5089ea63b4350085fccc1c0d23a52"
SRC_URI[sha256sum] = "0d5454928ae40c8a6b653caa35046cd8492c8743b5fbc22ff4009099d074c7ae"
