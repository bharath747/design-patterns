package designPatterns.bridge;

public interface FileDownloadImplementor {

    public Object downloadFile(String path);

    public boolean storeFile(Object object);
}