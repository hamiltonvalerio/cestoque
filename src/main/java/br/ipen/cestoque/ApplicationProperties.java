package br.ipen.cestoque;

import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;
import org.springframework.validation.annotation.Validated;


@Validated
@ConfigurationProperties(prefix = "br.ipen.cestoque")
public class ApplicationProperties {

	/* Local de armazenamento do relatório compilado */
	@NotNull
	private Resource localArmazenamento;

	/* Local dos arquivos JasperReports */
	@NotNull
	private Resource localRelatorio;

	public Resource getLocalArmazenamento() {
		return localArmazenamento;
	}

	public void setLocalArmazenamento(Resource localArmazenamento) {
		this.localArmazenamento = localArmazenamento;
	}

	public Resource getLocalRelatorio() {
		return localRelatorio;
	}

	public void setLocalRelatorio(Resource localRelatorio) {
		this.localRelatorio = localRelatorio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((localArmazenamento == null) ? 0 : localArmazenamento.hashCode());
		result = prime * result + ((localRelatorio == null) ? 0 : localRelatorio.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ApplicationProperties other = (ApplicationProperties) obj;
		if (localArmazenamento == null) {
			if (other.localArmazenamento != null)
				return false;
		} else if (!localArmazenamento.equals(other.localArmazenamento))
			return false;
		if (localRelatorio == null) {
			if (other.localRelatorio != null)
				return false;
		} else if (!localRelatorio.equals(other.localRelatorio))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ApplicationProperties [localArmazenamento=" + localArmazenamento + ", localRelatorio=" + localRelatorio
				+ "]";
	}

	
}
