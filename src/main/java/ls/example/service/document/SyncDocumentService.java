package ls.example.service.document;

import org.eclipse.lsp4j.Hover;
import org.eclipse.lsp4j.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.ExecutorService;

import static java.util.Collections.emptyList;

@Service
public class SyncDocumentService extends DocumentServiceBase
{
    @Autowired
    public SyncDocumentService(ExecutorService executorService)
    {
        super(executorService);
    }

    @Override
    protected Hover hoverSync(URI uri, Position position)
    {
        return position.getLine() > 100 ? new Hover(emptyList()) : new Hover();
    }
}
