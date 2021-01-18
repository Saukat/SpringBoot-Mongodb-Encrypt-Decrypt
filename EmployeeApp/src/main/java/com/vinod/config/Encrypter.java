package com.vinod.config;

import java.util.Base64;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.bol.crypt.CryptVault;
import com.bol.secure.CachedEncryptionEventListener;

@Component
public class Encrypter {
	
	private static final byte[] secretKey = Base64.getDecoder().decode("hqHKBLV83LpCqzKpf8OvutbCs+O5wX5BPu3btWpEvXA=");

	private static final byte[] oldKey =    Base64.getDecoder().decode("cUzurmCcL+K252XDJhhWI/A/+wxYXLgIm678bwsE2QM=");

	@Bean
	public CryptVault cryptVault() {
	   return new CryptVault()
	         .with256BitAesCbcPkcs5PaddingAnd128BitSaltKey(0, oldKey)
	         .with256BitAesCbcPkcs5PaddingAnd128BitSaltKey(1, secretKey)
	         // can be omitted if it's the highest version
	         .withDefaultKeyVersion(1);
	}

	@Bean
	public CachedEncryptionEventListener encryptionEventListener(CryptVault cryptVault) {
	   return new CachedEncryptionEventListener(cryptVault);
	}
	

}
