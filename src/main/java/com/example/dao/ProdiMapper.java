package com.example.dao;

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
public interface ProdiMapper {

	@Select("SELECT kode_univ, kode_prodi, nama_prodi FROM prodi WHERE kode_prodi = #{kode_prodi}")
	@Results(value = { @Result(property = "kode_univ", column = "kode_univ"),
			@Result(property = "kode_prodi", column = "kode_prodi"),
			@Result(property = "nama_prodi", column = "nama_prodi"),
			@Result(property = "univ", column = "kode_univ", javaType = UnivModel.class, many = @Many(select = "selectUniv")),
			@Result(property = "paraPeserta", column = "kode_prodi", javaType = List.class, many = @Many(select = "selectParaPeserta")) })
	ProdiModel selectProdi(@Param("kode_prodi") String kode_prodi);

	@Select("SELECT kode_univ, kode_prodi, nama_prodi FROM prodi")
	@Results(value = { @Result(property = "kode_univ", column = "kode_univ"),
			@Result(property = "kode_prodi", column = "kode_prodi"),
			@Result(property = "nama_prodi", column = "nama_prodi"),
			@Result(property = "univ", column = "kode_univ", javaType = UnivModel.class, many = @Many(select = "selectUniv")),
			@Result(property = "paraPeserta", column = "kode_prodi", javaType = List.class, many = @Many(select = "selectParaPeserta")) })
	List<ProdiModel> selectAllProdi();

	@Select("SELECT nomor, nama, tgl_lahir, p.kode_prodi " + "FROM peserta p " + "JOIN prodi pr "
			+ "ON p.kode_prodi=pr.kode_prodi " + "JOIN univ u " + "ON pr.kode_univ=u.kode_univ "
			+ "WHERE pr.kode_prodi=#{kode_prodi}")
	List<PesertaModel> selectParaPeserta(@Param("kode_prodi") String kode_prodi);

	@Select("SELECT kode_univ, nama_univ, url_univ FROM univ WHERE kode_univ=#{kode_univ}")
	UnivModel selectUniv(@Param("kode_univ") String kode_univ);

	@Insert("INSERT INTO prodi (kode_univ, kode_prodi, nama_prodi) VALUES (#{kode_univ}, #{kode_prodi}, #{nama_prodi})")
	void addProdi(ProdiModel prodi);

	@Delete("Delete from prodi where kode_prodi=#{kode_prodi}")
	void deleteProdi(@Param("kode_prodi") String kode_prodi);

	@Update("Update prodi set nama_prodi=#{prodi.nama_prodi} where kode_prodi=#{prodi.kode_prodi};")
	void updateProdi(@Param("prodi") ProdiModel prodi);

	@Select("SELECT nomor, nama, tgl_lahir "
	 		+ "FROM peserta p JOIN prodi pr "
	 		+ "ON p.kode_prodi = pr.kode_prodi "
	 		+ "JOIN univ u "
	 		+ "ON pr.kode_univ = u.kode_univ "
	 		+ "WHERE pr.kode_prodi=#{kode_prodi} "
	 		+ "ORDER BY YEAR(tgl_lahir) ASC LIMIT 1")
	 PesertaModel selectPesertaTermuda(String kode_prodi);

	 @Select("SELECT nomor, nama, tgl_lahir "
		 		+ "FROM peserta p JOIN prodi pr "
		 		+ "ON p.kode_prodi = pr.kode_prodi "
		 		+ "JOIN univ u "
		 		+ "ON pr.kode_univ = u.kode_univ "
		 		+ "WHERE pr.kode_prodi=#{kode_prodi} "
		 		+ "ORDER BY YEAR(tgl_lahir) DESC LIMIT 1")
	 PesertaModel selectPesertaTertua(String kode_prodi);
	 
}
