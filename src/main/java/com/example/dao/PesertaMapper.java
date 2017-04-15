package com.example.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.model.PesertaModel;
import com.example.model.ProdiModel;
import com.example.model.UnivModel;

@Mapper
public interface PesertaMapper {
	
	@Select("SELECT nomor, nama, tgl_lahir, kode_prodi FROM peserta WHERE nomor = #{nomor}")
    @Results(value={
    		@Result(property="nomor", column="nomor"),
    		@Result(property="nama", column="nama"),
    		@Result(property="tgl_lahir", column="tgl_lahir"),
    		@Result(property="kode_prodi", column="kode_prodi"),
    		@Result(property="univ", column="nomor",
    		javaType = UnivModel.class, many=@Many(select="selectUniv")),
    		@Result(property="prodi", column="nomor",
    		javaType = ProdiModel.class, many=@Many(select="selectProdi"))
    })
	PesertaModel selectPeserta(@Param("nomor") String nomor);
	
	@Select("SELECT kode_univ, nama_univ, url_univ "
			+ "FROM univ "
			+ "WHERE kode_univ = "
			+ "("
			+ "SELECT u.kode_univ "
			+ "FROM peserta p, prodi pr, univ u "
			+ "WHERE p.kode_prodi=pr.kode_prodi "
			+ "AND pr.kode_univ=u.kode_univ "
			+ "AND p.nomor=#{nomor})")
	UnivModel selectUniv(@Param("nomor") String nomor);
	
	@Select("SELECT kode_univ, kode_prodi, nama_prodi "
			+ "FROM prodi "
			+ "WHERE kode_prodi = (SELECT pr.kode_prodi FROM peserta p, prodi pr, univ u WHERE p.kode_prodi=pr.kode_prodi AND pr.kode_univ=u.kode_univ AND p.nomor=#{nomor})")
	ProdiModel selectProdi(@Param("nomor") String nomor);

	@Select("SELECT nomor, nama, tgl_lahir, kode_prodi FROM peserta")
    @Results(value={
    		@Result(property="nomor", column="nomor"),
    		@Result(property="nama", column="nama"),
    		@Result(property="tgl_lahir", column="tgl_lahir"),
    		@Result(property="kode_prodi", column="kode_prodi"),
    		@Result(property="univ", column="nomor",
    		javaType = UnivModel.class, many=@Many(select="selectUniv")),
    		@Result(property="prodi", column="nomor",
    		javaType = ProdiModel.class, many=@Many(select="selectProdi"))
    })
	List<PesertaModel> selectAllPeserta();

	@Insert("INSERT INTO peserta (nomor, nama, tgl_lahir, kode_prodi) VALUES (#{dosen}, #{nama}, #{tgl_lahir}, #{kode_prodi})")
	void addPeserta(PesertaModel peserta);
	
	@Delete("Delete from peserta where nomor=#{nomor}")
	void deletePeserta(@Param("nomor") String nomor);

	@Update("Update peserta set nama=#{peserta.nama}, tgl_lahir=#{peserta.tgl_lahir}, kode_prodi=#{peserta.kode_prodi} where nomor=#{peserta.nomor};")
	void updatePeserta(@Param("peserta") PesertaModel peserta);

	int hitungUmur(Date tgl_lahir);

	




}
