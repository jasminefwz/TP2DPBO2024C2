/*
Navicat MySQL Data Transfer

Source Server         : koneksi01
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : db_mahasiswa

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2024-03-20 13:05:29
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `mahasiswa`
-- ----------------------------
DROP TABLE IF EXISTS `mahasiswa`;
CREATE TABLE `mahasiswa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nim` varchar(255) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `jenis_kelamin` varchar(255) NOT NULL,
  `status_mhs` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of mahasiswa
-- ----------------------------
INSERT INTO `mahasiswa` VALUES ('1', '2203999', 'Amelia Zalfa Julianti', 'Perempuan', 'Lulus');
INSERT INTO `mahasiswa` VALUES ('2', '2202292', 'Muhammad Iqbal Fadhilah', 'Laki-laki', 'Cuti');
INSERT INTO `mahasiswa` VALUES ('3', '2202346', 'Muhammad Rifky Afandi', 'Laki-laki', 'Aktif');
INSERT INTO `mahasiswa` VALUES ('4', '2210239', 'Muhammad Hanif Abdillah', 'Laki-laki', 'Tidak Aktif');
INSERT INTO `mahasiswa` VALUES ('5', '2202046', 'Nurainun', 'Perempuan', 'Lulus');
INSERT INTO `mahasiswa` VALUES ('6', '2205101', 'Kelvin Julian Putra', 'Laki-laki', 'Cuti');
INSERT INTO `mahasiswa` VALUES ('7', '2200163', 'Rifanny Lysara Annastasya', 'Perempuan', 'Aktif');
INSERT INTO `mahasiswa` VALUES ('8', '2202869', 'Revana Faliha Salma', 'Perempuan', 'Tidak Aktif');
INSERT INTO `mahasiswa` VALUES ('9', '2209489', 'Rakha Dhifiargo Hariadi', 'Laki-laki', 'Lulus');
INSERT INTO `mahasiswa` VALUES ('10', '2203142', 'Roshan Syalwan Nurilham', 'Laki-laki', 'Cuti');
INSERT INTO `mahasiswa` VALUES ('11', '2200311', 'Raden Rahman Ismail', 'Laki-laki', 'Aktif');
INSERT INTO `mahasiswa` VALUES ('12', '2200978', 'Ratu Syahirah Khairunnisa', 'Perempuan', 'Tidak Aktif');
INSERT INTO `mahasiswa` VALUES ('13', '2204509', 'Muhammad Fahreza Fauzan', 'Laki-laki', 'Lulus');
INSERT INTO `mahasiswa` VALUES ('14', '2205027', 'Muhammad Rizki Revandi', 'Laki-laki', 'Cuti');
INSERT INTO `mahasiswa` VALUES ('15', '2203484', 'Arya Aydin Margono', 'Laki-laki', 'Aktif');
INSERT INTO `mahasiswa` VALUES ('16', '2200481', 'Marvel Ravindra Dioputra', 'Laki-laki', 'Tidak Aktif');
INSERT INTO `mahasiswa` VALUES ('17', '2209889', 'Muhammad Fadlul Hafiizh', 'Laki-laki', 'Lulus');
INSERT INTO `mahasiswa` VALUES ('18', '2206697', 'Rifa Sania', 'Perempuan', 'Cuti');
INSERT INTO `mahasiswa` VALUES ('20', '2204343', 'Meiva Labibah Putri', 'Perempuan', 'Tidak Aktif');
INSERT INTO `mahasiswa` VALUES ('23', '2200598', 'Jas Noor Fawzia', 'Perempuan', 'Aktif');
