package br.com.marcoshssilva.mhpasswordmanager.passwordservice.domain.services.data.keys.converters;

import br.com.marcoshssilva.mhpasswordmanager.passwordservice.domain.services.data.keys.models.AbstractKeyPayloadDecodedDto;
import br.com.marcoshssilva.mhpasswordmanager.passwordservice.domain.services.data.keys.models.KeyPayloadEncodedDto;

public interface IKeyDecodedToEncodedConverter<T extends AbstractKeyPayloadDecodedDto> {
    KeyPayloadEncodedDto convert(T data, String key) throws KeyEncodedErrorConverterException;
}
