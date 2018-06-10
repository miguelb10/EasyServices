package com.upc.service;

import com.upc.entity.Solicitud;

public interface SolicitudService {
	Iterable<Solicitud> listAllSolicitud();
	Solicitud getSolicitudById(Integer id);
	Solicitud saveSolicitud(Solicitud solicitud);
	void deleteSolicitud(Integer id);

}
