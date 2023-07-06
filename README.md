# Meta petaLinux layer to add labtool support for arm64 based factory tester

// Copyright (C) 2023, Advanced Micro Devices, Inc. All rights reserved.
// SPDX-License-Identifier: MIT

## Instructions
To build PetaLinux root file-system with embedded labtools support for factory tester:

On a linux machine which has [prerequisites for PetaLinux tools](https://docs.xilinx.com/r/en-US/ug1144-petalinux-tools-reference-guide/Prerequisites?tocId=RYSIsrA_Lds1LL2CKm626Q) satisfied -

1. Create PetaLinux rootfs project
   ```bash
    source /proj/petalinux/2023.1/petalinux-v2023.1_daily_latest/tool/petalinux-v2023.1-final/settings.sh
    petalinux-create -t project -s <board>.bsp
    petalinux-config -c rootfs
   ```
2. In rootfs menuconfig options obtained using command - `petalinux-config -c rootfs` enable following options -
   1. In Filesystem packages → base → busybox: Enable busybox
   ![Alt text](https://raw.gitenterprise.xilinx.com/chipscope-designs/vnx-factory-tester/master/linux/plnx_rootfs/docs/images/image-1.png)
   2. In Filesystem packages → console → network → wget: Enable wget
   ![Alt text](https://raw.gitenterprise.xilinx.com/chipscope-designs/vnx-factory-tester/master/linux/plnx_rootfs/docs/images/image-2.png)
   3. In Filesystem packages → misc → python3: Make sure python3 is enabled
   ![Alt text](https://raw.gitenterprise.xilinx.com/chipscope-designs/vnx-factory-tester/master/linux/plnx_rootfs/docs/images/image-3.png)
   4. In Filesystem packages → misc → python3-git: Enable python3-git
   ![Alt text](https://raw.gitenterprise.xilinx.com/chipscope-designs/vnx-factory-tester/master/linux/plnx_rootfs/docs/images/image-4.png)
   5. In Image Features: Enable debug-tweaks, emtpy-root-password and serial-autologin-root
    ![Alt text](https://raw.gitenterprise.xilinx.com/chipscope-designs/vnx-factory-tester/master/linux/plnx_rootfs/docs/images/image-5.png)
3. Copy all labtools recipes from this repo under recipes-utils to `<petalinux-project-dir>/project-spec/meta-user/recipes-utils/`. e.g.
   ```bash
   $ cp -R meta-labtool-binaries/recipes-utils/* project-spec/meta-user/recipes-utils/
   ```
4. Append the lines from [petalinuxbsp.conf](meta-labtool-binaries/blob/main/recipes-core/images/petalinuxbsp.conf) to `<petalinux-project-dir>/project-spec/meta-user/conf/petalinuxbsp.conf`.
5. Append the lines from [petalinux-user-image.bbappend](meta-labtool-binaries/blob/main/recipes-core/images/petalinux-user-image.bbappend) to `<petalinux-project-dir>/project-spec/meta-user/conf/user-rootfsconfig`.
6. Build petalinux rootfs components and full rootfs -
   ```bash
   petalinux-build -c labtool-jtag-support
   petalinux-build -c python3-chipscopy
   petalinux-build -c rootfs
   ```
   After successful completion of this command, PetaLinux root file system will have labtool support.
   
NOTICE:
These recipes add packages to the petalinux root file system. 
A list of all the packages added to the root file system can be found in NOTICE_CONTAINER_FILE file  
