-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 01 Jun 2024 pada 17.24
-- Versi server: 10.4.32-MariaDB
-- Versi PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbtokopancing`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `detailtransaksi`
--

CREATE TABLE `detailtransaksi` (
  `id_detail` varchar(36) NOT NULL,
  `id_transaksi` varchar(36) NOT NULL,
  `id_produk` varchar(36) NOT NULL,
  `nama_produk` varchar(36) NOT NULL,
  `harga_produk` double NOT NULL,
  `jumlah_produk` int(100) NOT NULL,
  `subtotal_pembayaran` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struktur dari tabel `joran`
--

CREATE TABLE `joran` (
  `id_produk` varchar(36) NOT NULL,
  `bahan` varchar(255) NOT NULL,
  `panjang` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `joran`
--

INSERT INTO `joran` (`id_produk`, `bahan`, `panjang`) VALUES
('74d1e17b-47ca-4e13-977a-121183fdafa6', '12d', 12),
('c2c8be4e-2eca-43a5-84c0-5f1eaf0db20a', 'carbon', 4),
('e7bb302b-371e-4516-8bb1-e50e6f7d7f7d', 'carbon', 3);

-- --------------------------------------------------------

--
-- Struktur dari tabel `matakail`
--

CREATE TABLE `matakail` (
  `id_produk` varchar(36) NOT NULL,
  `ukuran` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `matakail`
--

INSERT INTO `matakail` (`id_produk`, `ukuran`) VALUES
('1241156d-4b32-4ee5-b109-921778b08318', '0.8');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pelet`
--

CREATE TABLE `pelet` (
  `id_produk` varchar(36) NOT NULL,
  `rasa` varchar(255) NOT NULL,
  `berat` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struktur dari tabel `pembayaran`
--

CREATE TABLE `pembayaran` (
  `id_pembayaran` varchar(50) NOT NULL,
  `id_transaksi` varchar(50) DEFAULT NULL,
  `bank_penerima` varchar(50) DEFAULT NULL,
  `nama_penerima` varchar(50) DEFAULT NULL,
  `norek_penerima` int(50) DEFAULT NULL,
  `bank_pengirim` varchar(50) DEFAULT NULL,
  `nama_pengirim` varchar(50) DEFAULT NULL,
  `norek_pengirim` int(50) NOT NULL,
  `nominal_transfer` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `pembayaran`
--

INSERT INTO `pembayaran` (`id_pembayaran`, `id_transaksi`, `bank_penerima`, `nama_penerima`, `norek_penerima`, `bank_pengirim`, `nama_pengirim`, `norek_pengirim`, `nominal_transfer`) VALUES
('830b87e0-96f1-4330-8eca-e48006dd6f59', 'caa91cf9-0b08-4da2-98bf-0b4918860195', 'Mandiri', 'Dwi Reza', 10203040, 'dqw', '21', 12, 5000),
('b63a4d5a-2680-4f72-9721-88381e86ca8e', 'd822b4bf-f9c7-40fd-a158-ac08f04b1379', 'Mandiri', 'Dwi Reza', 10203040, 'BANK JAGO', 'DIPA', 13245, 25000),
('c4483693-093a-4070-9d52-6171bf36258f', 'b69c35ca-deee-48e5-a75b-7c9f1c4123be', 'Mandiri', 'Dwi Reza', 10203040, 'bank3', 'bank3', 12133, 1400000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `produk`
--

CREATE TABLE `produk` (
  `id_produk` varchar(36) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `merek` varchar(255) NOT NULL,
  `harga` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `produk`
--

INSERT INTO `produk` (`id_produk`, `nama`, `merek`, `harga`) VALUES
('1241156d-4b32-4ee5-b109-921778b08318', 'mata kail super', 'xxkail', 5000),
('74d1e17b-47ca-4e13-977a-121183fdafa6', 'number one joran', '123', 9),
('c2c8be4e-2eca-43a5-84c0-5f1eaf0db20a', 'carl best joran', 'carmaxiss', 324552),
('e744040a-85b3-4b80-8f2b-fbdefa07a1b5', 'saasa', 'sasasa', 1221),
('e7bb302b-371e-4516-8bb1-e50e6f7d7f7d', 'joran super maxx', 'maxxset', 350000),
('fcb8e417-8658-408d-be8d-2a4d500579dd', '2121w', '21sdwqd', 122);

-- --------------------------------------------------------

--
-- Struktur dari tabel `senar`
--

CREATE TABLE `senar` (
  `id_produk` varchar(36) NOT NULL,
  `ketebalan` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `senar`
--

INSERT INTO `senar` (`id_produk`, `ketebalan`) VALUES
('e744040a-85b3-4b80-8f2b-fbdefa07a1b5', 0.4);

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaksi`
--

CREATE TABLE `transaksi` (
  `id_transaksi` varchar(36) NOT NULL,
  `pembeli` varchar(50) NOT NULL,
  `total_pembayaran` double NOT NULL,
  `status_transaksi` enum('waiting_payment','waiting_validate','success_payment','') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `transaksi`
--

INSERT INTO `transaksi` (`id_transaksi`, `pembeli`, `total_pembayaran`, `status_transaksi`) VALUES
('b69c35ca-deee-48e5-a75b-7c9f1c4123be', 'dipa', 1400000, 'success_payment'),
('caa91cf9-0b08-4da2-98bf-0b4918860195', 'dipa', 5000, 'success_payment'),
('d822b4bf-f9c7-40fd-a158-ac08f04b1379', 'dipa', 25000, 'success_payment');

-- --------------------------------------------------------

--
-- Struktur dari tabel `users`
--

CREATE TABLE `users` (
  `id_user` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` enum('admin','pelanggan','','') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `users`
--

INSERT INTO `users` (`id_user`, `username`, `password`, `role`) VALUES
(3, 'reza', '123', 'pelanggan'),
(9, 'admin', 'admin', 'admin'),
(14, 'dipa', '123', 'pelanggan'),
(16, 'udin', '123', 'pelanggan'),
(17, 'jek', '123', 'pelanggan'),
(18, 'dummy', '123', 'pelanggan');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `detailtransaksi`
--
ALTER TABLE `detailtransaksi`
  ADD PRIMARY KEY (`id_detail`) USING BTREE,
  ADD KEY `id_transaksi` (`id_transaksi`);

--
-- Indeks untuk tabel `joran`
--
ALTER TABLE `joran`
  ADD PRIMARY KEY (`id_produk`);

--
-- Indeks untuk tabel `matakail`
--
ALTER TABLE `matakail`
  ADD PRIMARY KEY (`id_produk`);

--
-- Indeks untuk tabel `pembayaran`
--
ALTER TABLE `pembayaran`
  ADD PRIMARY KEY (`id_pembayaran`);

--
-- Indeks untuk tabel `produk`
--
ALTER TABLE `produk`
  ADD PRIMARY KEY (`id_produk`);

--
-- Indeks untuk tabel `senar`
--
ALTER TABLE `senar`
  ADD PRIMARY KEY (`id_produk`);

--
-- Indeks untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`id_transaksi`);

--
-- Indeks untuk tabel `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `users`
--
ALTER TABLE `users`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `detailtransaksi`
--
ALTER TABLE `detailtransaksi`
  ADD CONSTRAINT `detailtransaksi_ibfk_1` FOREIGN KEY (`id_transaksi`) REFERENCES `transaksi` (`id_transaksi`);

--
-- Ketidakleluasaan untuk tabel `joran`
--
ALTER TABLE `joran`
  ADD CONSTRAINT `joran_ibfk_1` FOREIGN KEY (`id_produk`) REFERENCES `produk` (`id_produk`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
